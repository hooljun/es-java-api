package com.es;

import com.es.entity.EmployeeEntity;
import com.es.entity.RoleEntity;
import com.es.qo.EmployeeQueryObject;
import com.es.qo.PageResult;
import com.es.repository.IEmployeeRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class EmployeeTest extends ApplicationTest {

    @Autowired
    private IEmployeeRepository employeeRepository;

    /**
     * 测试通过id获取文档
     */
    @Test
    public void get() throws Exception {
        EmployeeEntity employee = employeeRepository.get(1L);
        System.out.println(employee);
    }

    /**
     * 添加和修改文档
     */
    @Test
    public void inster() throws Exception {
        for (long i = 0; i < 10; i++) {
            EmployeeEntity employeeEntity = new EmployeeEntity();
            employeeEntity.setId(i);
            employeeEntity.setAge(20);
            employeeEntity.setName("张三" + i);
            employeeEntity.setAbout("张三张三张三张三张三张三张三张三张三张三张三张三张三张三张三张三张三张三" + i);
            List<Map<String ,Object>> roleList = new ArrayList<>();
            for (int y = 0; y < 3; y++) {
                Map<String, Object> role = new HashMap<>(8);
                role.put("id", y);
                role.put("roleName", "开发" + y);
                role.put("roleCode", "develop" + y);
                roleList.add(role);
            }
            employeeEntity.setRoleList(roleList);
            employeeRepository.insertOrUpdate(employeeEntity);
        }
    }

    @Test
    public void update() throws Exception {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setId(0L);
        employeeEntity.setName("张三");
        List<Map<String ,Object>> roleList = new ArrayList<>();
        Map<String, Object> role = new HashMap<>(8);
        role.put("id", 0);
        role.put("roleName", "财务部");
        role.put("roleCode", "finance");
        roleList.add(role);
        Map<String, Object> role2 = new HashMap<>(8);
        role2.put("id", 1);
        role2.put("roleName", "小卖部");
        role2.put("roleCode", "shop");
        roleList.add(role2);
        employeeEntity.setRoleList(roleList);
        employeeRepository.insertOrUpdate(employeeEntity);
    }

    /**
     * 测试获取所有文档
     */
    @Test
    public void getAll() throws Exception {
        List<EmployeeEntity> list = employeeRepository.getAll();
        list.forEach(employee -> {
            System.out.println(employee);
        });
    }

    /**
     * 搜索测试
     */
    @Test
    public void search() throws Exception {
        EmployeeQueryObject qo = new EmployeeQueryObject();
        qo.setKeyword("张三");
        PageResult pageResult = employeeRepository.search(qo);
        pageResult.getData().forEach(employee -> {
            System.out.println(employee);
        });
    }
}

