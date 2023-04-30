package com.king.waimai.controller;

import com.king.waimai.common.R;
import com.king.waimai.pojo.AddressBook;
import com.king.waimai.service.AddressBookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * 用户登录类
 */
@Slf4j
@RestController
@RequestMapping("/addressBook")
public class AddressBookController {

    @Autowired
    private AddressBookService addressBookService;

    /**
     * 根据用户信息查询收获地址
     *
     * @param session
     * @return
     */
    @GetMapping("/list")
    public R<List<AddressBook>> addressBookList(HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        List<AddressBook> addressBooks =
                addressBookService.selectByAddressBookeId(userId);
        return R.success(addressBooks);
    }

    /**
     * 添加收获地址
     *
     * @param session
     * @param addressBook
     * @return
     */
    @PostMapping("")
    public R<String> addressBookInsert(HttpSession session, @RequestBody AddressBook addressBook) {
        Long userId = (Long) session.getAttribute("userId");
        addressBook.setCreateTime(new Date());
        addressBook.setCreateUser(userId);
        addressBook.setIsDefault("0");
        addressBook.setUpdateTime(new Date());
        addressBook.setUpdateUser(userId);
        addressBook.setIsDeleted(0);
        addressBook.setUserId(userId);
        addressBookService.insertAll(addressBook);
        return R.success("添加成功");
    }

    /**
     * 根据地址id 查询信息
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public R<AddressBook> selectById(@PathVariable("id") Long id) {
        return R.success(addressBookService.selectById(id));
    }

    /**
     * 根据id 删除地址信息
     *
     * @param ids
     * @return
     */
    @DeleteMapping("")
    public R<String> deletebyId(Long ids) {
        addressBookService.deleteById(ids);
        return R.success("删除成功");
    }

    @PutMapping("")
    public R<String> updateAddressBook(HttpSession session, @RequestBody AddressBook addressBook) {
        Long userId = (Long) session.getAttribute("userId");
        addressBook.setUpdateTime(new Date());
        addressBook.setUpdateUser(userId);
        addressBookService.updateAddressBook(addressBook);
        return R.success("修改成功");
    }


    @PutMapping("/default")
    @Transactional
    public R<AddressBook> updateByUserIdAndId(HttpSession session, @RequestBody AddressBook addressBook) {
        Long userId = (Long) session.getAttribute("userId");
        addressBookService.updateByUserId(userId);
        addressBookService.updateById(addressBook.getId());
        return R.success(addressBook);
    }

    @GetMapping("/default")
    public R<AddressBook> selectByUserId(){
        return R.success(addressBookService.selectByUserId());

    }

}


























