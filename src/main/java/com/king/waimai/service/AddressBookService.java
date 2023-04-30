package com.king.waimai.service;


import com.king.waimai.pojo.AddressBook;

import java.util.List;

public interface AddressBookService {
    /**
     * 查询全部
     * @return
     */
    List<AddressBook> selectAll();

    /**
     * 添加收获地址信息
     * @param addressBook 收获地址
     * @return
     */
    Integer insertAll(AddressBook addressBook);

    /**
     * 根据用户的id 查询用户的数据
     */
    List<AddressBook> selectByAddressBookeId(Long userId);

    /**
     * 根据id 返回用户的数据
     * @param id
     * @return
     */
    AddressBook selectById(Long id);

    /**
     * 根据地址id 删除地址信息
     * @param id
     * @return
     */
    Boolean deleteById(Long id);

    /**
     * 修改地址数据
     * @param addressBook
     * @return
     */
    Integer updateAddressBook(AddressBook addressBook);

    /**
     * 根据用户id 把用户的数据设置为0 不是默认的
     * @param userId
     * @return
     */
    Integer updateByUserId(Long userId);

    /**
     * 根据用户的id 去设置用户的默认收获地址
     * @param id
     * @return
     */
    Integer updateById(Long id);


    /**
     * 根据用户的id 查询数据
     * @param
     * @return
     */
    AddressBook selectByUserId();
}
