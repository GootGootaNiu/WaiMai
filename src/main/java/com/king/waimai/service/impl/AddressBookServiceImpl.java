package com.king.waimai.service.impl;

import com.king.waimai.mapper.AddressBookMapper;
import com.king.waimai.pojo.AddressBook;
import com.king.waimai.service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AddressBookServiceImpl implements AddressBookService {

    @Autowired
    private AddressBookMapper addressBookMapper;

    /**
     * 查询全部
     * @return
     */
    @Override
    public List<AddressBook> selectAll() {
        return addressBookMapper.selectAll();
    }

    /**
     * 添加数据
     * @param addressBook 收获地址
     * @return
     */
    @Override
    public Integer insertAll(AddressBook addressBook) {
        return addressBookMapper.insertAll(addressBook);
    }

    /**
     * 根据用户id 查询数据
     * @param userId
     * @return
     */
    @Override
    public List<AddressBook> selectByAddressBookeId(Long userId) {
        return addressBookMapper.selectByAddressBookeId(userId);
    }

    /**
     * 根据用户的id查询用户的数据
     * @param id
     * @return
     */
    @Override
    public AddressBook selectById(Long id) {
        return addressBookMapper.selectById(id);
    }

    /**
     * 用户地址信息
     * @param id
     * @return
     */
    @Override
    public Boolean deleteById(Long id) {
        return addressBookMapper.deleteById(id);
    }

    @Override
    public Integer updateAddressBook(AddressBook addressBook) {
        return addressBookMapper.updateAddressBook(addressBook);
    }

    /**
     * 把用户的收获地址全部设置为不是默认值
     * @param userId
     * @return
     */
    @Override
    public Integer updateByUserId(Long userId) {
        return addressBookMapper.updateByUserId(userId);
    }

    /**
     * 设置用户的默认收获地址
     * @param id
     * @return
     */
    @Override
    public Integer updateById(Long id) {
        return addressBookMapper.updateById(id);
    }

    @Override
    public AddressBook selectByUserId() {
        return addressBookMapper.selectByUserId();
    }
}
