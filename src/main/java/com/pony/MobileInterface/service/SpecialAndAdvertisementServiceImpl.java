package com.pony.MobileInterface.service;

import com.pony.MobileInterface.entity.Advertisement;
import com.pony.MobileInterface.entity.AdvertisementOrSpecial;
import com.pony.MobileInterface.entity.Special;
import com.pony.MobileInterface.entity.SpecialTextItem;
import com.pony.dao.ProductForMobileDAO;
import com.pony.dao.SpecialAndAdvertisementForMobileDAO;
import com.pony.productManage.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2017/3/3 0003.
 */
@Service
public class SpecialAndAdvertisementServiceImpl implements SpecialAndAdvertisementService{
    @Autowired
    SpecialAndAdvertisementForMobileDAO specialAndAdvertisementForMobileDAO;
    @Autowired
    private ProductForMobileDAO productForMobileDAO;
    /**
     * 获取首页最上端广告
     *
     *
     * @return List<Product>
     */
    public Advertisement getTopAdvertisement(){

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String currentTime = dateFormat.format(new Date());
        Advertisement advertisement = specialAndAdvertisementForMobileDAO.getTopAdvertisement(currentTime);
        return advertisement;

    }

    /**
     * 获取专题或广告列表
     *
     *
     * @return List<Product>
     */
    public List<AdvertisementOrSpecial> getAdvertisementOrSpecialList(){

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String currentTime = dateFormat.format(new Date());
        List<Advertisement> advertisementList = specialAndAdvertisementForMobileDAO.getAdvertisementByWeight(currentTime);
        List<Special> specialList = specialAndAdvertisementForMobileDAO.getSpecialListByWeight(currentTime);
        List<AdvertisementOrSpecial> advertisementOrSpecialList = new ArrayList<AdvertisementOrSpecial>();
        AdvertisementOrSpecial aos;
        for(Advertisement ad:advertisementList){
            aos = new AdvertisementOrSpecial();
            aos.setAdvertisement(ad);
            aos.setWeight(ad.getWeight());
            advertisementOrSpecialList.add(aos);
        }
        for(Special special : specialList){
            aos = new AdvertisementOrSpecial();
            aos.setSpecial(special);
            aos.setWeight(special.getWeight());
            advertisementOrSpecialList.add(aos);
        }
        MyComparator mc = new MyComparator() ;
        Collections.sort(advertisementOrSpecialList, mc);
        return advertisementOrSpecialList;

    }


    /**
     * 按专题ID获取专题
     *
     * @param specialId
     * @return Special
     */
    public Special getSpecialBySpecialId(Integer specialId){

        Special special = specialAndAdvertisementForMobileDAO.getSpecialBySpecialId(specialId);
        List<SpecialTextItem> specialTextItemList = specialAndAdvertisementForMobileDAO.getSpecialTextItemListBySpecialId(specialId);
        List<Product> productList = specialAndAdvertisementForMobileDAO.getProductListBySpecialId(specialId);
        Double price;
        for(Product product:productList){
            price = productForMobileDAO.getProductPriceByProductId(product.getId()).getPrice();
            if(price == null){
                price = 0.0;
            }
            product.setOriginalPrice(price);
        }
        special.setProductList(productList);
        special.setSpecialTextItemList(specialTextItemList);
        return special;

    }


    class MyComparator implements Comparator {

        public int compare(Object o1,Object o2) {
            AdvertisementOrSpecial e1=(AdvertisementOrSpecial)o1;
            AdvertisementOrSpecial e2=(AdvertisementOrSpecial)o2;
            return  e2.getWeight()-e1.getWeight();

        }
    }
}
