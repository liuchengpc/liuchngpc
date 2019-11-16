package com.apatech.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.apatech.domain.Student;
import com.apatech.service.StudentSevice;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("StudentController")
public class StudentController {
	@Autowired
	private StudentSevice dao;
	
	@RequestMapping("/tzs")
	public String selectAll(String tz) {
		System.out.println("进入跳转");
		System.out.println(tz);
		return tz;
	}
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	@RequestMapping("/add")
	public String add() {
		return "add";
	}
	@RequestMapping("/update")
	public String update() {
		return "update";
	}
	
	@RequestMapping("/toupload")
	public String toupload() {
		System.out.println("foewjiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
		System.out.println("哈哈哈哈哈哈");
		return "upload";
	}
	
	 /**上传地址*/
    @Value("${file.upload.path}")
    private String filePath;

    // 跳转上传页面
    @RequestMapping("toupload")
    public String test() {
        return "upload";
    }

    // 执行上传
    @RequestMapping("upload")
    public String upload(@RequestParam("file") MultipartFile file, Model model) {
        // 获取上传文件名
        String filename = file.getOriginalFilename();
        // 定义上传文件保存路径
        String path = filePath+"rotPhoto/";
        // 新建文件
        File filepath = new File (path, filename);
        // 判断路径是否存在，如果不存在就创建一个
        if (!filepath.getParentFile().exists()) {
            filepath.getParentFile().mkdirs();
        }
        try {
            // 写入文件
            file.transferTo(new File(path + File.separator + filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 将src路径发送至html页面
        model.addAttribute("filename", "/images/rotPhoto/"+filename);
        return "Page";
    }
	
	
	
	@RequestMapping(value = "deleteByPrimaryKey",method = RequestMethod.GET)
	@ResponseBody
    public Map<String, String> deleteByPrimaryKey(Integer id,Model model) {
		Map<String, String> map=new HashMap<String,String>();
		
    	int i =dao.deleteByPrimaryKey(id);
		if (i>0) {
			map.put("code", "1");
			map.put("message", "删除成功！");
		}else {
			map.put("code", "2");
			map.put("message", "删除失败！");
		}
		
		return map;
    }

	@RequestMapping(value = "insert",method = RequestMethod.POST)
    public int insert(Student record) {
    	return dao.insert(record);
    }

	@RequestMapping(value = "insertSelective",method = RequestMethod.POST)
	@ResponseBody
    public Map<String, String> insertSelective(@RequestBody Student student) {
		Map<String, String> map=new HashMap<String,String>();
		System.out.println("实体："+student.toString());
    	int i=dao.insertSelective(student);
    	if (i>0) {
			map.put("code", "1");
			map.put("message", "新增成功！");
		}else {
			map.put("code", "2");
			map.put("message", "新增失败！");
		}
		return map;
    }
	
	

	@RequestMapping(value = "selectByPrimaryKey",method = RequestMethod.GET)
	@ResponseBody
    public Student selectByPrimaryKey(Integer id) {
		System.out.println("进入selectByPrimaryKey");
		System.out.println("id="+id);
    	return dao.selectByPrimaryKey(id);
    }
	
	@RequestMapping("/selectAll")
	public String selectAll(Model model) {
		List<Student> list = dao.selectAll();
		model.addAttribute("list", list);
		return "index";
	}
	
	@RequestMapping(value = "selectAllpage",method = RequestMethod.GET)
	@ResponseBody
	public PageInfo<Student> selectAllpage( Integer pageNum,Integer pageSize){
		System.out.println(pageNum+"/"+pageSize);
    	PageInfo<Student> page=dao.selectAllpage(pageNum, pageSize);
    	return page;
    }

	@RequestMapping(value = "updateByPrimaryKeySelective",method = RequestMethod.POST)
	@ResponseBody
    public Map<String, String> updateByPrimaryKeySelective(@RequestBody Student student) {
		System.out.println("进入");
		System.out.println();
		Map<String, String> map=new HashMap<String, String>();
		System.out.println("实体："+student.toString());
    	int i=dao.updateByPrimaryKeySelective(student);
    	if (i>0) {
			map.put("code", "1");
			map.put("message", "修改成功！");
		}else {
			map.put("code", "2");
			map.put("message", "修改失败！");
		}
		return map;
		
    }

	@RequestMapping(value = "updateByPrimaryKey",method = RequestMethod.POST)
	@ResponseBody
    public int updateByPrimaryKey(@RequestBody Student record) {
    	return dao.updateByPrimaryKey(record);
    }

}