package com.itvillage.chapter05.chapter0501;

public class FutureExampleSync {
    public static void main(String[] args){
        long startTime = System.nanoTime();

        CarRepairShop shop = new CarRepairShop();

        // 차량 수리비
        int carRepairCost = shop.getCarRepairCostSync(10);
        System.out.println("# (1) 차량 수리비 계산이 완료되었습니다.");
        System.out.println("# 차량 수리비는 " + carRepairCost + "원 입니다.");

        // 회사에 병가 신청
        requestSickLeave("20170903-01");

        // 보험 접수
        requestInsurance("44나4444");

        long endTime = System.nanoTime();

        long executeTime = (endTime - startTime) / 1_000_000;

        System.out.println();
        System.out.println("# 처리 시간: " + executeTime);
    }

    private static void requestSickLeave(String empNumber) {
        try {
            Thread.sleep(1000);

            System.out.println("# (2) 병가 신청이 완료되었습니다.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void requestInsurance(String carNumber) {
        try {
            Thread.sleep(1000);

            System.out.println("# (3) 보험 접수가 완료 되었습니다.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}