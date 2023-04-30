package com.king.waimai.mapper;

import com.king.waimai.pojo.AddressBook;
import com.king.waimai.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 收获地址
 */
@Mapper
public interface AddressBookMapper {

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
     * 修改用户地址信息
     * @param addressBook 修改的地址数据
     * @return 返回受影响的行数
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
