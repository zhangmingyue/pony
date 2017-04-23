package com.pony.MobileInterface.util;

import com.pony.MobileInterface.entity.ChildOrder;
import com.pony.MobileInterface.entity.ChildOrderProduct;
import com.pony.MobileInterface.entity.ProductTemp;
import com.pony.MobileInterface.entity.UsableContainerTypeAndNumber;
import com.pony.domain.Container;

import java.util.*;

/**
 * Created by Administrator on 2017/4/16 0016.
 */
public class ContainerCalculateUtil {


    //柜子装货
    public static List<ChildOrder> loader(List<ProductTemp> productTempList, List<UsableContainerTypeAndNumber> usableContainerTypeAndNumberList) {

        List<ChildOrder> childOrderList = new ArrayList<ChildOrder>();
        UsableContainerTypeAndNumber u;
        //对可用柜门做从大到小排序
        MyComparator mc = new MyComparator() ;
        Collections.sort(usableContainerTypeAndNumberList, mc);
        //以可以放下的最小柜门，为产品分类
        for(ProductTemp pt:productTempList) {
            for (int i=usableContainerTypeAndNumberList.size()-1;i>=0;i--) {
                if(checkSize(pt,usableContainerTypeAndNumberList.get(i))){
                    usableContainerTypeAndNumberList.get(i).getMyProductTempStack().push(pt);
                    pt = null;
                    break;
                }
            }
            if(pt!=null){
                return null;
            }
        }
        //链表化
        for(int i=usableContainerTypeAndNumberList.size()-1;i>=0;i--) {
            u = usableContainerTypeAndNumberList.get(i);
            if((i+1)<=usableContainerTypeAndNumberList.size()-1) {
                u.setBigger(usableContainerTypeAndNumberList.get(i + 1));
            }
            if((i-1)>=0){
                u.setSmaller(usableContainerTypeAndNumberList.get(i - 1));
            }
        }
        //如果无货可装直接跳出所有循环
        boolean flag;
        ChildOrder childOrder;
        Map<Integer,ChildOrderProduct> childOrderProductMap;
        List<ChildOrderProduct> childOrderProductList;
        for(int i=usableContainerTypeAndNumberList.size()-1;i>=0;i--){
            u = usableContainerTypeAndNumberList.get(i);
            Stack<Container> containerStack = u.getContainerStack();
            for(int j=0;j<u.getContainerQuantity();j++){
                if(!u.getMyProductTempStack().empty()){
                    childOrder = new ChildOrder();
                    childOrder.setContainer(containerStack.pop());
                    childOrder.setContainerId(childOrder.getContainer().getId());
                    childOrderProductMap = new HashMap<Integer,ChildOrderProduct>();

                    //跑完出来要么一个柜子装满了，要么产品装完了
                    flag = recursionLoadProduct(childOrderProductMap,u,u.getVolume());
                    childOrderProductList = new ArrayList<>();
                    childOrderProductList.addAll(childOrderProductMap.values());
                    childOrder.setChildOrderProductList(childOrderProductList);
                    childOrderList.add(childOrder);
                    if(flag){
                        return childOrderList;
                    }
                }else{
                    break;
                }
            }

        }
        return null;
    }
    //检查时间点是否可用
    public static int checkTimeCodeIsUsable(List<ProductTemp> productTempList, List<UsableContainerTypeAndNumber> usableContainerTypeAndNumberList){
        int sum = 0;
        int sumContainerVolume = 0;
        int sumProductVolume = 0;
        for(UsableContainerTypeAndNumber u:usableContainerTypeAndNumberList){
            sum+=u.getContainerQuantity();
            sumContainerVolume+=u.getVolume()*u.getContainerQuantity();
            //删除剩余量为0的柜门
            if(u.getContainerQuantity() == 0){
                usableContainerTypeAndNumberList.remove(u);
            }
        }
        for(ProductTemp pt:productTempList){
            sumProductVolume+=pt.getVolume()*pt.getNumber();
        }
        //柜门总量剩余为0或货物体积大于总存储量60%直接返回不可用
        if(sum==0||sumProductVolume>sumContainerVolume){
            return 1;
        }
        //对可用柜门做从大到小排序
        MyComparator mc = new MyComparator() ;
        Collections.sort(usableContainerTypeAndNumberList, mc);
        //以可以放下的最小柜门，为产品分类
        for(ProductTemp pt:productTempList) {
            for (int i=usableContainerTypeAndNumberList.size()-1;i>=0;i--) {
                if(checkSize(pt,usableContainerTypeAndNumberList.get(i))){
                    usableContainerTypeAndNumberList.get(i).getMyProductTempStack().push(pt);
                    pt = null;
                    break;
                }
            }
            if(pt!=null){
                return 1;
            }
        }
//        //将产品从小到大压入栈
//        Stack<ProductTemp> stack = new Stack<ProductTemp>);
//        for(UsableContainerTypeAndNumber u:usableContainerTypeAndNumberList){
//            for(ProductTemp pt:u.getMyProductTempList()){
//                stack.push(pt);
//            }
//        }

        UsableContainerTypeAndNumber u;
        //链表化
        for(int i=usableContainerTypeAndNumberList.size()-1;i>=0;i--) {
            u = usableContainerTypeAndNumberList.get(i);
            if((i+1)<=usableContainerTypeAndNumberList.size()-1) {
                u.setBigger(usableContainerTypeAndNumberList.get(i + 1));
            }
            if((i-1)>=0){
                u.setSmaller(usableContainerTypeAndNumberList.get(i - 1));
            }
        }
        ProductTemp pt;
        //如果无货可装直接跳出所有循环
        boolean flag;
        for(int i=usableContainerTypeAndNumberList.size()-1;i>=0;i--){
            u = usableContainerTypeAndNumberList.get(i);

            for(int j=0;j<u.getContainerQuantity();j++){
                if(!u.getMyProductTempStack().empty()){
                    //跑完出来要么一个柜子装满了，要么产品装完了
                    flag = recursionTestLoadProduct(u,u.getVolume());
                    if(flag){
                        return 0;
                    }
                }else{
                    break;
                }
            }

        }
//        for(UsableContainerTypeAndNumber uc:usableContainerTypeAndNumberList){
//            if(!uc.getMyProductTempStack().empty()){
//                return 1;
//            }
//        }
        //如果前面未出现无货可装，说明柜子不够
        return 1;

    }
    //递归测试装货
    public static boolean recursionTestLoadProduct(UsableContainerTypeAndNumber u,int volume){
        while(!u.getMyProductTempStack().empty()){
            //如果剩余体积比货物体积大
            if(volume>=u.getMyProductTempStack().peek().getVolume()){
                //剩余体积减去货物体积
                volume -= u.getMyProductTempStack().peek().getVolume();
                //站定货物剩余量-1
                u.getMyProductTempStack().peek().setNumber(u.getMyProductTempStack().peek().getNumber()-1);
                //如果栈顶货物剩余量为0
                if(u.getMyProductTempStack().peek().getNumber()==0){
                    //栈顶货物出栈
                    u.getMyProductTempStack().pop();
                }
            }else{
                if(u.getSmaller()!=null) {
                    //如果小一号柜子不为空或小一号柜子产品栈不为空
                    if(!u.getSmaller().getMyProductTempStack().empty()||u.getSmaller().getSmaller()!=null) {
                        return recursionTestLoadProduct(u.getSmaller(), volume);
                    }else{
                        //装满了
                        return false;
                    }
                }else{
                    //装满了
                    return false;
                }
            }
        }
        if(u.getSmaller()!=null) {
            if(!u.getSmaller().getMyProductTempStack().empty()||u.getSmaller().getSmaller()!=null) {
                return recursionTestLoadProduct(u.getSmaller(), volume);
            }else {
                //无货可装了
                return true;
            }
        }else{
            //无货可装了
            return true;
        }
    }

    //递归装货
    public static boolean recursionLoadProduct(Map<Integer,ChildOrderProduct> childOrderProductMap,UsableContainerTypeAndNumber u,int volume){
        ChildOrderProduct childOrderProduct;
        while(!u.getMyProductTempStack().empty()){
            //如果剩余体积比货物体积大
            if(volume>=u.getMyProductTempStack().peek().getVolume()){
                //剩余体积减去货物体积
                volume -= u.getMyProductTempStack().peek().getVolume();
                if(childOrderProductMap.get(u.getMyProductTempStack().peek().getProductId())==null) {
                    childOrderProduct = initializeChildOrderProduct(u.getMyProductTempStack().peek());
                    childOrderProductMap.put(childOrderProduct.getId(), childOrderProduct);
                }else{
                    childOrderProduct = childOrderProductMap.get(u.getMyProductTempStack().peek().getProductId());
                    childOrderProduct.setNumber(childOrderProduct.getNumber()+1);
                }
                //站定货物剩余量-1
                u.getMyProductTempStack().peek().setNumber(u.getMyProductTempStack().peek().getNumber()-1);
                //如果栈顶货物剩余量为0
                if(u.getMyProductTempStack().peek().getNumber()==0){
                    //栈顶货物出栈
                    u.getMyProductTempStack().pop();
                }
            }else{
                if(u.getSmaller()!=null) {
                    //如果小一号柜子不为空或小一号柜子产品栈不为空
                    if(!u.getSmaller().getMyProductTempStack().empty()||u.getSmaller().getSmaller()!=null) {
                        return recursionLoadProduct(childOrderProductMap,u.getSmaller(), volume);
                    }else{
                        //装满了
                        return false;
                    }
                }else{
                    //装满了
                    return false;
                }
            }
        }
        if(u.getSmaller()!=null) {
            if(!u.getSmaller().getMyProductTempStack().empty()||u.getSmaller().getSmaller()!=null) {
                return recursionLoadProduct(childOrderProductMap,u.getSmaller(), volume);
            }else {
                //无货可装了
                return true;
            }
        }else{
            //无货可装了
            return true;
        }
    }
    private static ChildOrderProduct  initializeChildOrderProduct(ProductTemp pt){
        ChildOrderProduct childOrderProduct = new ChildOrderProduct();
        childOrderProduct.setNumber(1);
        childOrderProduct.setProductId(pt.getProductId());
        childOrderProduct.setPurchasePrice(ProductUtil.getProductNowPrice(pt.getProduct()));
//        childOrderProduct.set
        //todo

        return childOrderProduct;
    }
    public static boolean checkSize(ProductTemp pt,UsableContainerTypeAndNumber u){
        if(pt.getProductHigh()<u.getContainerHigh() &&
                pt.getProductLength()<u.getContainerLength()&&
                pt.getProductWidth()<u.getContainerWidth()){
            return true;
        }else{
            return false;
        }
    }
    static class MyComparator implements Comparator {

        public int compare(Object o1,Object o2) {
            UsableContainerTypeAndNumber e1=(UsableContainerTypeAndNumber)o1;
            UsableContainerTypeAndNumber e2=(UsableContainerTypeAndNumber)o2;
            return  e2.getVolume()-e1.getVolume();
        }
    }
}
