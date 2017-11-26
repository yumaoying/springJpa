package com.bjyada.demo.controller;

import com.bjyada.demo.entity.DecryData;
import com.bjyada.demo.entity.JsonReturn;
import com.bjyada.demo.service.DecryDataService;
import com.bjyada.demo.util.RSA;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.List;


/**
 * Created by Administrator on 2017/10/18.
 */
@Controller
public class DecryDataController {
    @Autowired
    DecryDataService decryDataService;

    @RequestMapping("/toadd")
    public String toadd(Model model,HttpServletRequest request) throws Exception{
        //获取公钥，私钥
        System.out.println(request.getHeader("User-Agent"));
        PublicKey pubk=RSA.getPubKeyFromPfx("F:\\self.pfx","atlas");
        PrivateKey privateKey=RSA.getPvkformPfx("F:\\self.pfx","atlas");
        RSAPublicKey pub = (RSAPublicKey)pubk;// 生成公钥
        RSAPrivateKey prik = (RSAPrivateKey) privateKey;// 生成私钥
        String publicKeyExponent = pub.getPublicExponent().toString(16);// 16进制
        String publicKeyModulus = pub.getModulus().toString(16);// 16进制
        model.addAttribute("publicKey",publicKeyModulus);
        return "decrydata_add";
    }
    @RequestMapping("/getJson")
    public @ResponseBody JsonReturn getJsonReturn(HttpServletRequest request){
        StringBuffer str=new StringBuffer();
        try {
            BufferedInputStream in=new BufferedInputStream(request.getInputStream());
            int i;
            char c;
            while((i=in.read())!=-1){
                c=(char)i;
                str.append(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONObject obj= JSONObject.fromObject(str.toString());
        String key=(String)obj.get("key");
        String value= (String)obj.get("value");
        //对value进行解密
        JsonReturn jsonReturn=new JsonReturn();
        try {
            PrivateKey privateKey=RSA.getPvkformPfx("F://self.pfx","atlas");
            Long starttime=System.currentTimeMillis();
            String dvalue=RSA.decrypt(value,privateKey);
            Long endtime=System.currentTimeMillis();
            //设置并保存
            Integer dafter=new Integer(dvalue)+1;
            DecryData decryData=new DecryData();
            decryData.setTime(endtime-starttime);
            decryData.setValue(dafter);
            decryDataService.save(decryData);
            //对加1后进行加密
            PublicKey pubk=RSA.getPubKeyFromPfx("F://other.pfx","111111");
           String evalue= RSA.encrypt(dafter.toString(),pubk);
           jsonReturn.setKey(key);
           jsonReturn.setValue(evalue);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonReturn;
    }

    @RequestMapping("/toupdate")
    public String toaupdate(Integer id, Model model) {
        DecryData decryData = decryDataService.findByID(id);
        model.addAttribute("decryData", decryData);
        return "decrydata_info";
    }

    @RequestMapping("/save")
    @ResponseBody
    public JsonReturn save(JsonReturn jsondata) {
        System.out.println("============================================");
        System.out.println(jsondata);
        return new JsonReturn("nihao","hello");
    }
    @RequestMapping("/update")
    public String update(DecryData decryData){
        decryDataService.save(decryData);
        return "forward:findAll";
    }
    @RequestMapping("/delete")
    public String delete(Integer id, Model model) {
        decryDataService.delete(id);
        System.out.println("添加成功");
        return "forward:findAll";
    }

    @RequestMapping("/findAll")
    public String findAll(Model model) {
        List<DecryData> dlist = decryDataService.findAll();
        model.addAttribute("dlist", dlist);
        return "deceydata_list";
    }
}
