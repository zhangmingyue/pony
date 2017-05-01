package com.pony.MobileInterface.service;


import com.pony.MobileInterface.entity.ChildOrder;
import com.pony.MobileInterface.entity.ChildOrderProduct;
import com.pony.MobileInterface.entity.ProductOrder;
import com.pony.MobileInterface.entity.Stock;
import com.pony.MobileInterface.entity.queryBean.ChildOrderQueryBean;
import com.pony.MobileInterface.entity.queryBean.ProductOrderQueryBean;
import com.pony.MobileInterface.entity.queryBean.ProductQueryBean;
import com.pony.dao.*;
import com.pony.domain.AddressEntity;
import com.pony.domain.Container;
import com.pony.domain.ContainerUsage;
import com.pony.domain.SelfLiftingCabinet;
import com.pony.productManage.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by zhangmingyue on 2017/3/2 0002.
 */
@Service
public class ProductOrderForMobileServiceImpl implements ProductOrderForMobileService{

    @Autowired
    private ProductOrderForMobileDAO productOrderForMobileDAO;
    @Autowired
    private AddressDAO addressDAO;
    @Autowired
    private ChildOrderForMobileDAO childOrderForMobileDAO;
    @Autowired
    private StockForMobileDAO stockForMobileDAO;
    @Autowired
    private SelfLiftingCabinetForMobileDAO selfLiftingCabinetForMobileDAO;
    @Autowired
    private ProductForMobileDAO productForMobileDAO;
    @Autowired
    private ChildOrderProductForMobileDAO childOrderProductForMobileDAO;

    /**
     * 添加订单
     *
     * @param productOrder
     * @return Product
     */
    public int addProductOrder(ProductOrder productOrder){
        int check = productOrderForMobileDAO.addProductOrder(productOrder);
        List<ChildOrder> childOrderList = productOrder.getChildOrderList();
        int i=0;
        AddressEntity addressEntity = addressDAO.getAddressByAddressId(productOrder.getAddressId());
        for(ChildOrder childOrder:childOrderList){
            i++;
            childOrder.setChildOrderNumber(productOrder.getProductOrderNumber()+"-"+i);
            childOrder.setProductOrderId(productOrder.getId());
            childOrder.setUserId(productOrder.getUserId());
            childOrder.setAddressId(productOrder.getAddressId());
            DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            try {
                childOrder.setDeliveryDate(format1.parse(productOrder.getDeliveryDate()));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            childOrder.setTimeCode(productOrder.getTimeCode());
            childOrder.setReservationType(productOrder.getChildOrderReservationType());
            childOrder.setSelfLiftingCabinetId(addressEntity.getSelfLiftingCabinet());
            addChildOrder(childOrder);

        }
        if(check==0) {
            return 1;
        }else{
            return 0;
        }
    }
    private void addChildOrder(ChildOrder childOrder){
        int checkChildOrder;
        checkChildOrder = childOrderForMobileDAO.addChildOrder(childOrder);
        if(checkChildOrder==0){
            //todo throw
        }
        List<ChildOrderProduct> childOrderProductList = childOrder.getChildOrderProductList();
        int checkChildOrderProduct;
        int inventory;
        int usage;
        ContainerUsage containerUsage = new ContainerUsage();
        try {
            DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            containerUsage.setDeliveryDate(format1.parse(childOrder.getDeliveryDate()));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        containerUsage.setContainerId(childOrder.getContainerId());
        containerUsage.setTimeCode(childOrder.getTimeCode());
        containerUsage.setChildOrderId(childOrder.getId());
        containerUsage.setSelfLiftingCabinetId(childOrder.getSelfLiftingCabinetId());
        usage = selfLiftingCabinetForMobileDAO.checkContainerUsage(containerUsage);
        if(usage != 0){
            //todo throw
        }
        selfLiftingCabinetForMobileDAO.addContainerUsage(containerUsage);

        List<String> productIconUrlList = childOrder.getProductIconList();
        for(String productIconUrl:productIconUrlList){
            checkChildOrderProduct = childOrderForMobileDAO.addChildOrderProductIcon(productIconUrl ,childOrder.getId());
            if(checkChildOrderProduct == 0){
                //todo throw
            }
        }
        for(ChildOrderProduct childOrderProduct:childOrderProductList){
            childOrderProduct.setChildOrderId(childOrder.getId());
            inventory = stockForMobileDAO.getInventoryByStockId(childOrderProduct.getStockId());
            if(inventory < childOrderProduct.getPurchaseNumber()){
                //todo throw
            }
            checkChildOrderProduct = stockForMobileDAO.updateInventoryByStockId(childOrderProduct.getStockId(),childOrderProduct.getPurchaseNumber(),1);
            if(checkChildOrderProduct == 0){
                //todo throw
            }
            checkChildOrderProduct = childOrderProductForMobileDAO.addChildOrderProduct(childOrderProduct);
            if(checkChildOrderProduct == 0){
                //todo throw
            }

        }

    }
    /**
     * 根据订单id获取订单信息
     *
     * @param productOrderId
     * @return ProductOrder
     */
    public ProductOrder getProductOrderByOrderId(Integer productOrderId){
        //获取订单信息
        ProductOrder productOrder = productOrderForMobileDAO.getProductOrderByOrderId(productOrderId);
        //根据订单信息获取地址信息
        AddressEntity addressEntity = addressDAO.getAddressByAddressId(productOrder.getAddressId());
        //根据订单ID和子单类型获取预约和现货两个子单列表
        ChildOrderQueryBean childOrderQueryBean = new ChildOrderQueryBean();
        childOrderQueryBean.setProductOrderId(productOrder.getId());
//        childOrderQueryBean.setChildOrderType(productOrder.getChildOrderReservationType());
        List<ChildOrder> childOrderList = childOrderForMobileDAO.getChildOrderListByQueryBean(childOrderQueryBean);

        List<ChildOrderProduct> childOrderProductList;
        Product product;
        ProductQueryBean productQueryBean = new ProductQueryBean();
        for(ChildOrder childOrder:childOrderList){
            childOrderProductList =childOrderProductForMobileDAO.getChildOrderProductListByChildOrderId(childOrder.getId());
            for(ChildOrderProduct childOrderProduct:childOrderProductList){
                productQueryBean.setProductId(childOrderProduct.getProductId());
                product = getProductById(productQueryBean);
                childOrderProduct.setProduct(product);
            }
            childOrder.setChildOrderProductList(childOrderProductList);
        }
        productOrder.setAddressEntity(addressEntity);
        productOrder.setChildOrderList(childOrderList);
        return  productOrder;
    }
    /**
     * 根据查询条件获取订单列表
     *
     * @param productOrderQueryBean
     * @return List<ProductOrder>
     */
    public List<ProductOrder> getProductOrderListByQueryBean(ProductOrderQueryBean productOrderQueryBean){
        List<ProductOrder> productOrderList = productOrderForMobileDAO.getProductOrderListByQueryBean(productOrderQueryBean);
        AddressEntity addressEntity;
        List<String> productIconUrlList;
        for(ProductOrder po:productOrderList){
            productIconUrlList = productOrderForMobileDAO.getProductOrderProductIconListByProductOrderId(po.getId());
            addressEntity = addressDAO.getAddressByAddressId(po.getAddressId());
            po.setAddressEntity(addressEntity);
            po.setProductIconList(productIconUrlList);
        }
        return productOrderList;
    }
    /**
     * 根据查询条件获取各种状态子订单列表
     *
     * @param childOrderQueryBean
     * @return List<ChildOrder>
     */
    //todo 根据状态不同优化性能
    public List<ChildOrder> getChildOrderByQueryBean(ChildOrderQueryBean childOrderQueryBean){
        List<ChildOrder> childOrderList = childOrderForMobileDAO.getChildOrderListByQueryBean(childOrderQueryBean);
        List<ChildOrderProduct> childOrderProductList;
        Container container;
        Product product;
        ProductQueryBean productQueryBean;
        AddressEntity addressEntity;
        SelfLiftingCabinet selfLiftingCabinet;
        List<String> productIconUrlList;
        for(ChildOrder childOrder:childOrderList){
            if(childOrderQueryBean.getTimeFilter()==1) {
                childOrderProductList = childOrderProductForMobileDAO.getChildOrderProductListByChildOrderId(childOrder.getId());
                for(ChildOrderProduct childOrderProduct:childOrderProductList){
                    productQueryBean = new ProductQueryBean();
                    productQueryBean.setProductId(childOrderProduct.getProductId());
                    product = productForMobileDAO.getProductById(productQueryBean);
                    product.setOriginalPrice(productForMobileDAO.getProductPriceByProductId(product.getId(),getCurrentTime()).getPrice());
                    childOrderProduct.setProduct(product);
                }
                childOrder.setChildOrderProductList(childOrderProductList);
            }
            addressEntity = addressDAO.getAddressByAddressId(childOrder.getAddressId());
            container = selfLiftingCabinetForMobileDAO.getContainerById(childOrder.getContainerId());
            productIconUrlList = childOrderForMobileDAO.getChildOrderProductIconListByChildOrderId(childOrder.getId());
            selfLiftingCabinet = selfLiftingCabinetForMobileDAO.getSelfLiftingCabinetBySelfLiftingCabinetId(childOrder.getSelfLiftingCabinetId());
            childOrder.setContainer(container);
            childOrder.setAddressEntity(addressEntity);
            childOrder.setProductIconList(productIconUrlList);
            childOrder.setSelfLiftingCabinet(selfLiftingCabinet);
        }
        return childOrderList;
    }
//    /**
//     * 根据查询条件获取子订单售后列表
//     *
//     * @param childOrderQueryBean
//     * @return List<ChildOrder>
//     */
//    public List<ChildOrder> getAfterServiceChildOrderByQueryBean(ChildOrderQueryBean childOrderQueryBean){
//        List<ChildOrder> childOrderList = childOrderForMobileDAO.getChildOrderListByQueryBean(childOrderQueryBean);
//        List<ChildOrderProduct> childOrderProductList;
//        Container container;
//        Product product;
//        ProductQueryBean productQueryBean;
//        AddressEntity addressEntity;
//        SelfLiftingCabinet selfLiftingCabinet;
//        List<String> productIconUrlList;
//        for(ChildOrder childOrder:childOrderList){
////            childOrderProductList = childOrderProductForMobileDAO.getChildOrderProductListByChildOrderId(childOrder.getId());
////            for(ChildOrderProduct childOrderProduct:childOrderProductList){
////                productQueryBean = new ProductQueryBean();
////                productQueryBean.setProductId(childOrderProduct.getProductId());
////                product = productForMobileDAO.getProductById(productQueryBean);
////                product.setOriginalPrice(productForMobileDAO.getProductPriceByProductId(product.getId(),getCurrentTime()).getPrice());
////                childOrderProduct.setProduct(product);
////            }
////            childOrder.setChildOrderProductList(childOrderProductList);
//            addressEntity = addressDAO.getAddressByAddressId(childOrder.getAddressId());
//            container = selfLiftingCabinetForMobileDAO.getContainerById(childOrder.getContainerId());
//            productIconUrlList = childOrderForMobileDAO.getChildOrderProductIconListByChildOrderId(childOrder.getId());
//            selfLiftingCabinet = selfLiftingCabinetForMobileDAO.getSelfLiftingCabinetBySelfLiftingCabinetId(childOrder.getSelfLiftingCabinetId());
//            childOrder.setContainer(container);
//            childOrder.setAddressEntity(addressEntity);
//            childOrder.setProductIconList(productIconUrlList);
//            childOrder.setSelfLiftingCabinet(selfLiftingCabinet);
//        }
//        return childOrderList;
//    }
    /**
     * 删除过期订单（不是真的删除）
     *
     * @param
     * @return List<ChildOrder>
     */
    public int deleteExpiredProductOrder(){
        int[] expiredProductOrderIds = productOrderForMobileDAO.getExpiredProductOrderList();
        int[] expiredChildOrderIds = childOrderForMobileDAO.batchGetExpiredChildOrderId(expiredProductOrderIds);
        List<ChildOrderProduct> childOrderProductList= childOrderProductForMobileDAO.batchGetChildOrderProduct(expiredChildOrderIds);
        for(ChildOrderProduct childOrderProduct:childOrderProductList){
            stockForMobileDAO.updateInventoryByStockId(childOrderProduct.getStockId(),childOrderProduct.getPurchaseNumber(),0);
        }
        childOrderProductForMobileDAO.batchDeleteChildOrderProduct(expiredChildOrderIds);
        selfLiftingCabinetForMobileDAO.batchDeleteContainerUsage(expiredChildOrderIds);
        childOrderForMobileDAO.batchSetChildOrderExpired(expiredProductOrderIds);
        productOrderForMobileDAO.batchSetProductOrderExpired(expiredProductOrderIds);
        return 0;
    }

    /**
     * 根据子订单ID修改柜门密码（存放于子单内）密码需要为String类型（如0102。。。int变为102.。）
     */

    public int setPasswordByChildOrderId(Integer productOrderId , String password){
        return childOrderForMobileDAO.setPasswordByChildOrderId(productOrderId,password);
    }
    /**
     * 修改子订单状态
     *
     * @param state
     * @return int
     */
    public int updateChildOrderState(Integer childOrderId,Integer state){
        return childOrderForMobileDAO.updateChildOrderState(childOrderId,state);
    }
    /**
     * 根据订单ID更改订单状态为已付款
     *
     * @param productOrderId
     * @return int
     */
    public int updateProductOrderStateToPaid(Integer productOrderId){
        int check = 0;
        check = productOrderForMobileDAO.updateProductOrderState(productOrderId,1);
        if(check==0){
            return check;
        }
        check = childOrderForMobileDAO.updateChildOrderStateByProductOrderId(productOrderId,1);
        if(check==0){
            return check;
        }
        return check;
    }
    /**
     * 根据子订单ID获取子订单详细信息
     */
    public ChildOrder getChildOrderById(Integer childOrderId){
        ChildOrder childOrder = childOrderForMobileDAO.getChildOrderById(childOrderId);
        SelfLiftingCabinet selfLiftingCabinet = selfLiftingCabinetForMobileDAO.getSelfLiftingCabinetBySelfLiftingCabinetId(childOrder.getSelfLiftingCabinetId());
        Container container = selfLiftingCabinetForMobileDAO.getContainerById(childOrder.getContainerId());
        List<ChildOrderProduct> childOrderProductList = childOrderProductForMobileDAO.getChildOrderProductListByChildOrderId(childOrder.getId());
        Product product;
        ProductQueryBean productQueryBean;
        for(ChildOrderProduct childOrderProduct:childOrderProductList){
            productQueryBean = new ProductQueryBean();
            productQueryBean.setProductId(childOrderProduct.getProductId());
            product = productForMobileDAO.getProductById(productQueryBean);
            product.setOriginalPrice(productForMobileDAO.getProductPriceByProductId(product.getId(),getCurrentTime()).getPrice());
            childOrderProduct.setProduct(product);
        }
        childOrder.setChildOrderProductList(childOrderProductList);
        childOrder.setSelfLiftingCabinet(selfLiftingCabinet);
        childOrder.setContainer(container);
        return childOrder;
    }

    @Override
    public Stock getStockByWarehouseIdAndProductId(Integer warehouseId, Integer productId) {
        return stockForMobileDAO.getStockByWarehouseIdAndProductId(warehouseId,productId);
    }

    public String getCurrentTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String currentTime = dateFormat.format(new Date());
        return currentTime;
    }
    private Product getProductById(ProductQueryBean productQueryBean){

        Product product = productForMobileDAO.getProductById(productQueryBean);
        product.setOriginalPrice(productForMobileDAO.getProductPriceByProductId(productQueryBean.getProductId(),getCurrentTime()).getPrice());
        return product;
    }
}
