package com.example.security.service;

import com.example.security.entity.MemberInfo;
import com.example.security.entity.User;
import com.example.security.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

@Service
public class CustomUserService implements UserDetailsService {
    @Autowired
    private MemberInfoMapper memberInfoMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user = new User();

        MemberInfo memberInfo = memberInfoMapper.selectByPrimaryKey(username);

        if (memberInfo!=null){
            user.setUsername(memberInfo.getId());
            user.setPassword( memberInfo.getPassword());

            //登入的時後順便計算到期日
            checkTakeOfficeDateThisYear(memberInfo);
        } else {
            throw new UsernameNotFoundException("no name");
        }
        return user;
    }

    /**
     * 計算今年的到期日
     * @param memberInfo
     */
    private void checkTakeOfficeDateThisYear(MemberInfo memberInfo){
        ZoneId zoneId = ZoneId.of("Asia/Shanghai");
        ZonedDateTime zonedDateTime = ZonedDateTime.now(zoneId);
        final LocalDate today = zonedDateTime.toLocalDate();
        Date takeOfficeDateThisYearTmp = memberInfo.getTakeOfficeDateThisYear();
        LocalDate takeOfficeDate = memberInfo.getTakeOfficeDate().toInstant().atZone(zoneId).toLocalDate();
        LocalDate takeOfficeDateThisYear = null;

        if (null == takeOfficeDateThisYearTmp){
            takeOfficeDateThisYear = takeOfficeDate;
            memberInfo.setTakeOfficeDateThisYear(memberInfo.getTakeOfficeDate());
            memberInfoMapper.updateByPrimaryKey(memberInfo);
        } else {
            takeOfficeDateThisYear = memberInfo.getTakeOfficeDateThisYear().toInstant().atZone(zoneId).toLocalDate();
        }

        Period period = Period.between(takeOfficeDateThisYear,today);
        if (period.getYears()>=1) {
            LocalDate newTakeOfficeDateThisYear = takeOfficeDateThisYear.plusYears(1);
            memberInfo.setTakeOfficeDateThisYear(Date.from(newTakeOfficeDateThisYear.atStartOfDay(zoneId).toInstant()));
            memberInfoMapper.updateByPrimaryKey(memberInfo);
        }
    }

}