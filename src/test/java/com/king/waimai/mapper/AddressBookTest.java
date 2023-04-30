package com.king.waimai.mapper;

import com.king.waimai.pojo.AddressBook;
import com.king.waimai.pojo.Category;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@Slf4j
@SpringBootTest
public class AddressBookTest {

    @Autowired
    private AddressBookMapper addressBookMapper;

    /**
     * 查询用户全部信息
     */
    @Test
    public void selectAll() {
        List<AddressBook> list =
                addressBookMapper.selectAll();
        // 查询全部用户信息
        for (AddressBook c : list
        ) {
            System.out.println(c);
        }
    }

    @Test
    public void selectById() {
        List<AddressBook> addressBooks = addressBookMapper.selectByAddressBookeId(1417012167126876162L);
        for (AddressBook addressBook : addressBooks) {
            System.out.println(addressBook);
        }
    }




}
