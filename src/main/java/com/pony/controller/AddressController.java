package com.pony.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Strings;
import com.pony.MobileInterface.service.SelfLiftingCabinetForMobileService;
import com.pony.domain.*;
import com.pony.service.AddressService;
import com.pony.service.DistrictService;
import com.pony.service.ResidentialAreaService;
import com.pony.service.SelfLiftingCabinetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author: qiaoyi
 * @edit:
 * @created:17/4/8
 */
@Controller
@RequestMapping(value = "/address")
public class AddressController {
    @Autowired
    DistrictService districtService;
    @Autowired
    ResidentialAreaService residentialAreaService;
    @Autowired
    SelfLiftingCabinetService selfLiftingCabinetService;
    @Autowired
    AddressService addressService;
    @Autowired
    SelfLiftingCabinetForMobileService selfLiftingCabinetForMobileService;

    @RequestMapping(value = "get_all_district", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject getDistrict(HttpServletRequest request,
                                  HttpServletResponse response) {
        List<DistrictEntity> districts = districtService.getAllList();
        JSONObject result = new JSONObject();
        result.put("result", true);
        result.put("districts", districts);
        return result;
    }

    @RequestMapping(value = "get_residential_by_district", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject getResidential(HttpServletRequest request,
                                     HttpServletResponse response) {
        String district = request.getParameter("district");
        String phone = request.getParameter("phone");
        JSONObject result = new JSONObject();

        if (Strings.isNullOrEmpty(district)) {
            result.put("code", 0);
            result.put("result", false);
            return result;
        }

        Map<Integer, String> residentialAreaEntities = residentialAreaService.
                getPartListByDistrictIdMap(Integer.parseInt(district));

        result.put("result", true);
        result.put("code", 200);
        result.put("residential", residentialAreaEntities);
        return result;
    }

    @RequestMapping(value = "get_self_lifting_cabinet", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject getSelfLiftingCabinet(HttpServletRequest request,
                                            HttpServletResponse response) {
        String residentialAreaId = request.getParameter("residential_area_id");
        String phone = request.getParameter("phone");
        JSONObject result = new JSONObject();

        if (Strings.isNullOrEmpty(residentialAreaId)) {
            result.put("code", 0);
            result.put("result", false);
            return result;
        }

        List<SelfLiftingCabinetEntity> selfLiftingCabinetEntities =
                selfLiftingCabinetService
                        .getSelfLiftingCabinetByResidential(
                                Integer.parseInt(residentialAreaId));


        result.put("result", true);
        result.put("code", 200);
        result.put("self_lifting_cabinet", selfLiftingCabinetEntities);
        return result;
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject addAddress(HttpServletRequest request,
                                 HttpServletResponse response) {
        String district = request.getParameter("district");
        String residentialArea = request.getParameter("residential_area");
        String selfLiftingCabinet = request.getParameter("self_lifting_cabinet");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String userName = request.getParameter("user_name");
        String reveivePhone=request.getParameter("receive_phone");

        JSONObject result = new JSONObject();
        result.put("result", false);
        if (Strings.isNullOrEmpty(district) || Strings.isNullOrEmpty(residentialArea) ||
                Strings.isNullOrEmpty(selfLiftingCabinet) || Strings.isNullOrEmpty(name) ||
                Strings.isNullOrEmpty(phone)) {
            result.put("code", 0);
            return result;
        }

        Date time = new Date();

        SelfLiftingCabinet selfLiftingCabinet1 = selfLiftingCabinetForMobileService.
                getSelfLiftingCabinetBySelfLiftingCabinetId(Integer.parseInt(selfLiftingCabinet));
        int warehouseId = -1;
        if (selfLiftingCabinet1 != null) {
            warehouseId = selfLiftingCabinet1.getWarehouseId();
        }

        DistrictEntity district1 = districtService.
                getDistrictById(Integer.parseInt(district));
        ResidentialAreaEntity residentialAreaEntity = residentialAreaService.
                getResidentialAreaEntityById(Integer.parseInt(residentialArea));

        SelfLiftingCabinetEntity selfLiftingCabinet2 = selfLiftingCabinetService.
                getSelfLiftingCabinetById(Integer.parseInt(selfLiftingCabinet));

        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setPhone(phone);
        addressEntity.setWarehouseId(warehouseId);
        addressEntity.setDistrict(Integer.parseInt(district));
        addressEntity.setResidentialArea(Integer.parseInt(residentialArea));
        addressEntity.setSelfLiftingCabinet(Integer.parseInt(selfLiftingCabinet));
        addressEntity.setName(name);
        addressEntity.setDt(time);
        addressEntity.setUserName(userName);
        addressEntity.setRecieve_phone(reveivePhone);
        if (district1 != null) {
            addressEntity.setDistrictName(district1.getDistrictName());
        }
        if (residentialAreaEntity != null) {
            addressEntity.setResidentialAreaName(residentialAreaEntity.getResidentialAreaName());
        }
        if (selfLiftingCabinet2 != null) {
            addressEntity.setCabinetNumber(selfLiftingCabinet2.getCabinetNumber());
            addressEntity.setLocation(selfLiftingCabinet2.getLocation());
        }

        int insertResult = addressService.insert(addressEntity);
        if (insertResult >= 1) {
            result.put("result", true);
            result.put("code", 200);
            result.put("id", addressEntity.getId());
            return result;
        }
        result.put("code", 1);
        return result;
    }

    @RequestMapping(value = "get_by_phone", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject getAddress(HttpServletRequest request,
                                 HttpServletResponse response) {
        String phone = request.getParameter("phone");
        JSONObject result = new JSONObject();

        if (Strings.isNullOrEmpty(phone)) {
            result.put("result", false);
            result.put("code", 0);
            return result;
        }

        result.put("result", true);
        List<AddressEntity> addressEntities = addressService.getAddressByPhone(phone);
        result.put("data", addressEntities);
        return result;
    }

    @RequestMapping(value = "set_default_address", method = RequestMethod.POST)
    @ResponseBody
    public JSONObject setDefaultAddress(HttpServletRequest request,
                                        HttpServletResponse response) {
        JSONObject result = new JSONObject();
        result.put("result", false);
        String id = request.getParameter("id");
        String phone = request.getParameter("phone");

        if (Strings.isNullOrEmpty(id) || Strings.isNullOrEmpty(phone)) {
            result.put("code", 0);
            return result;
        }

        //先刷一遍
        addressService.setZeroDefaultAddress(phone);

        int defaultAddress = Integer.parseInt(id);
        if (addressService.setDefaultAddressById(defaultAddress, 1)) {
            result.put("result", true);
            result.put("code", 200);
            return result;
        }
        result.put("code", 1);
        return result;
    }

}
