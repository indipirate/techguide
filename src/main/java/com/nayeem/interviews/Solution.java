package com.nayeem.interviews;/*
We are building a program to manage a gym's membership. The gym has multiple members, each with a unique ID, name, and membership status. The program allows gym staff to add new members, update members status, and get membership statistics.

Definitions:
* A "member" is an object that represents a gym member. It has properties for the ID, name, and membership status.
* A "membership" is a class which is used for managing members in the gym.

To begin with, we present you with two tasks:
1-1) Read through and understand the code below. Please take as much time as necessary, and feel free to run the code.
1-2) The test for Membership is not passing due to a bug in the code. Make the necessary changes to Membership to fix the bug.

We are currently updating our system to include information about workouts for our members. As part of this update, we have introduced the Workout class, which represents a single workout session for a member. Each object of the Workout class has a unique ID, as well as a start time and end time that are represented in the number of minutes spent from the start of the day. You can assume that all the Workouts are from the same day.

To implement these changes, we need to add two functions to the Membership class:

2.1) The `addWorkout` function should be used to add a workout session for a member. If the given member does not exist while calling this function, the workout can be ignored.

2.2) The `getAverageWorkoutDurations` function should calculate the average duration of workouts for each member in minutes and return the results as a map.

To assist you in testing these new functions, we have provided the testGetAverageWorkoutDurations function.
*/

import java.util.*;
import java.util.stream.Collectors;

class Workout {
    /**
     * This class represents a single workout session for a member.
     * Each object of the Workout class has a unique ID, as well as
     * a start time and end time that are represented in the number
     * of minutes spent from the start of the day.
     */

    private int id;
    private int startTime;
    private int endTime;

    public Workout(int id, int startTime, int endTime) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getDuration() {
        return endTime - startTime;
    }
}

enum MembershipStatus {
    /*
        Membership Status is of three types: BASIC, PRO and ELITE.
        BASIC is the default membership a new member gets.
        PRO and ELITE are paid memberships for the gym.
    */
    BASIC,
    PRO,
    ELITE
}

class Member {
    /* Data about a gym member.*/
    public int memberId;
    public String name;
    public MembershipStatus membershipStatus;

    public Member(int memberId, String name, MembershipStatus membershipStatus) {
        this.memberId = memberId;
        this.name = name;
        this.membershipStatus = membershipStatus;
    }

    @Override
    public String toString() {
        return "Member ID: " + memberId + ", Name: " + name + ", Membership Status: " + membershipStatus;
    }
}

class Membership {
    /*
        Data for managing a gym membership, and methods which staff can
        use to perform any queries or updates.
    */
    public List<Member> members;

    public Map<Integer, List<Workout>> memberWorkoutMap = new HashMap<>();

    public Membership() {
        members = new ArrayList<>();
    }

    public void addWorkout(int Id, Workout workout) {
        Optional<Member> memberOptional = members.stream().filter(m -> m.memberId == Id).findFirst();
        memberOptional.ifPresent(member -> {
            List<Workout> membersWorkoutList = memberWorkoutMap.getOrDefault(Id, new ArrayList<>());
            membersWorkoutList.add(workout);
            memberWorkoutMap.put(Id, membersWorkoutList);
        });
    }
    // 2.2) The `getAverageWorkoutDurations` function should calculate the average duration of workouts for each member in minutes and return the results as a map.

    public Map<Integer, Integer> getAverageWorkoutDurations() {
        return memberWorkoutMap.entrySet().stream().map(entry -> {
            Integer avg = entry.getValue().stream().map(Workout::getDuration).reduce(0, Integer::sum) / entry.getValue().size();
            return new AbstractMap.SimpleEntry<>(entry.getKey(), avg);
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void updateMembership(int memberId, MembershipStatus membershipStatus) {
        for (Member member : members) {
            if (member.memberId == memberId) {
                member.membershipStatus = membershipStatus;
                break;
            }
        }
    }

    public MembershipStatistics getMembershipStatistics() {
        int totalMembers = members.size();
        int totalPaidMembers = 0;
        for (Member member : members) {
            if (member.membershipStatus != MembershipStatus.BASIC) {
                totalPaidMembers++;
            }
        }
        double conversionRate = (totalPaidMembers / (double) totalMembers) * 100.0;
        return new MembershipStatistics(totalMembers, totalPaidMembers, conversionRate);
    }
}

class MembershipStatistics {
    /*
        Class for returning the getMembershipStatistics result
    */
    public int total_members;
    public int total_paid_members;
    public double conversion_rate;

    public MembershipStatistics(int total_members, int total_paid_members, double conversion_rate) {
        this.total_members = total_members;
        this.total_paid_members = total_paid_members;
        this.conversion_rate = conversion_rate;
    }
}

public class Solution {
    /*
        This is not a complete test suite, but tests some basic functionality of
        the code and shows how to use it.
    */
    public static void main(String[] args) {
        testMember();
        testMembership();
        testGetAverageWorkoutDurations();
    }

    public static void testMember() {
        System.out.println("Running testMember");
        Member testMember = new Member(1, "John Doe", MembershipStatus.BASIC);
        assert testMember.memberId == 1;
        assert testMember.name.equals("John Doe");
        assert testMember.membershipStatus == MembershipStatus.BASIC;
    }

    public static void testMembership() {
        System.out.println("Running testMembership");
        Membership testMembership = new Membership();
        Member testMember = new Member(1, "John Doe", MembershipStatus.BASIC);
        testMembership.addMember(testMember);
        assert testMembership.members.size() == 1;
        assert testMembership.members.get(0).equals(testMember);

        testMembership.updateMembership(1, MembershipStatus.PRO);
        assert testMembership.members.get(0).membershipStatus == MembershipStatus.PRO;

        Member testMember2 = new Member(2, "Alex C", MembershipStatus.BASIC);
        testMembership.addMember(testMember2);

        Member testMember3 = new Member(3, "Marie C", MembershipStatus.ELITE);
        testMembership.addMember(testMember3);

        MembershipStatistics attendanceStats = testMembership.getMembershipStatistics();
        assert attendanceStats.total_members == 3;
        assert attendanceStats.total_paid_members == 2;
        assert Math.abs(attendanceStats.conversion_rate - 66.66) < 0.1;
    }

    public static void testGetAverageWorkoutDurations() {
        System.out.println("Running testGetAverageWorkoutDurations");
        Membership testMembership = new Membership();
        Member testMember1 = new Member(1, "John Doe", MembershipStatus.PRO);
        testMembership.addMember(testMember1);

        Member testMember2 = new Member(2, "Alex C", MembershipStatus.BASIC);
        testMembership.addMember(testMember2);

        Member testMember3 = new Member(3, "Marie C", MembershipStatus.ELITE);
        testMembership.addMember(testMember3);

        Workout testWorkout1 = new Workout(1, 10, 20);
        Workout testWorkout2 = new Workout(2, 15, 35);
        Workout testWorkout3 = new Workout(3, 50, 90);
        Workout testWorkout4 = new Workout(4, 100, 155);
        Workout testWorkout5 = new Workout(5, 120, 200);
        Workout testWorkout6 = new Workout(6, 300, 400);
        Workout testWorkout7 = new Workout(7, 2000, 2010);

        testMembership.addWorkout(1, testWorkout1);
        testMembership.addWorkout(2, testWorkout2);
        testMembership.addWorkout(3, testWorkout3);
        testMembership.addWorkout(1, testWorkout4);
        testMembership.addWorkout(2, testWorkout5);
        testMembership.addWorkout(3, testWorkout6);
        testMembership.addWorkout(1, testWorkout7);

        Map<Integer, Integer> averageDurations = testMembership.getAverageWorkoutDurations();
        assert Math.abs(averageDurations.get(1) - 25.0) < 0.1;
        assert Math.abs(averageDurations.get(2) - 50.0) < 0.1;
        assert Math.abs(averageDurations.get(3) - 70.0) < 0.1;
    }
}