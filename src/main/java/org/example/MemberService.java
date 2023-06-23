package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MemberService {
    List<Member> memberList = new ArrayList<>();
     List<Admin> adminList = Arrays.asList(
         new Admin("admin1", "qwer", "가가가", "01011111111"),
         new Admin("admin2", "asdf", "나나나", "01022222222"),
         new Admin("admin3", "zxcv", "다다다", "0103333")
     );


     public Member getMemeber(String id, String pw){
         for (Member member : memberList) {
             if(member.getId().equals(id) && member.getPw().equals(pw)){
                 return member;
             }
         }
         return null;
     }

     public Admin getAdmin(String id, String pw){
         for (Admin admin : adminList) {
             if(admin.getId().equals(id) && admin.getPw().equals(pw)){
                 return admin;
             }
         }
         return null;
     }

     public boolean isIdExist(String id){
         for (Member member : memberList) {
             if(member.getId().equals(id)){
                 return true;
             }
         }
         return false;
     }

     public String getMemberIdFromName(String name){
         for (Member member : memberList) {
             if(member.getMemberName().equals(name)){
                 return member.getId();
             }
         }
         return null;
     }

    public String getMemberPwFromId(String findId) {
        for (Member member : memberList) {
            if(member.getId().equals(findId)){
                return member.getPw();
            }
        }
        return null;
    }

    public void upgrade(Member member, int amount){
        member.setMileage(member.getMileage() + amount);
        if(member.getGrade().equals("G") && member.getMileage() >= 100000){
            member.setGrade("S");
            System.out.println("===================================================================");
            System.out.println("일반 회원의 마일리지 금액이 100000을 넘어갔기 떄문에 우수회원으로 변경되었습니다");
            System.out.println("===================================================================");
            System.out.println("해당 회원에게 담당자가 랜덤으로 배정됩니다...");
            Random random = new Random();
            Admin  manager = adminList.get(random.nextInt(adminList.size()));
            member.setManager(manager);
            System.out.println("배정된 담당자 : " + manager.getId());
            System.out.println("해당 회원의 마일리지가 초기화됩니다...");
            member.setMileage(0);
        }
    }

    public void inquiryAllMembers() {
         memberList.forEach(member -> {
             System.out.println(member.toStringMasked());
         });
    }

    public List<Member> getMemberList() {
        return memberList;
    }

    public List<Admin> getAdminList() {
        return adminList;
    }


}
