package com.ecl.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindDuplicateObjectInList {

    public static List<MyBean> generateListOfBean() {

        final List<MyBean> listResultBean = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            final MyBean mybean = new MyBean();
            mybean.setId(String.valueOf(i));
            mybean.setNature("nature" + String.valueOf(i));
            mybean.setCode("code" + String.valueOf(i));
            listResultBean.add(mybean);
        }

        final MyBean mybean1 = new MyBean();
        mybean1.setId(String.valueOf(10));
        mybean1.setNature("nature" + String.valueOf(6));
        mybean1.setCode("code" + String.valueOf(6));

        final MyBean mybean2 = new MyBean();
        mybean2.setId(String.valueOf(11));
        mybean2.setNature("nature" + String.valueOf(8));
        mybean2.setCode("code" + String.valueOf(8));

        listResultBean.add(mybean1);
        listResultBean.add(mybean2);

        return listResultBean;
    }

    public static void main(final String[] args) {
        final List<Integer> numbers = Arrays.asList(new Integer[] { 1, 2, 1, 3, 4, 4 });
        numbers.stream().filter(i -> Collections.frequency(numbers, i) > 1).collect(Collectors.toSet()).forEach(
                System.out::println);

        final List<MyBean> listResultBean = generateListOfBean();

        final List<MyBean> listResultBeanToVerif = generateListOfBean();

        for (final MyBean ibean : listResultBean) {

            final MyBean isExcludedBean = new MyBean();
            isExcludedBean.setCode(ibean.getCode());
            isExcludedBean.setNature(ibean.getNature());
            listResultBeanToVerif.add(isExcludedBean);
        }

        // listResultBean.stream().allMatch(predicate)

        listResultBeanToVerif.stream().filter(i -> Collections.frequency(listResultBeanToVerif, i) > 1).collect(
                Collectors.toSet()).forEach(System.out::println);

        // List<MyBean> subBusinessLinesDuplicateNature = (List<MyBean>) listResultBean.stream().filter(i ->
        // Collections.frequency(listResultBean, i.getNature()) >1).collect(Collectors.toSet());
        // collect all duplicate SubBusinessLineCode in all duplicate SubBusinessLineNature list
//		subBusinessLinesDuplicateNature.stream().forEach(System.out::println);
//
//		List<MyBean> subBusinessLinesDuplicateNatureAndCode  = (List<MyBean>) listResultBean.stream().filter(i -> Collections.frequency(listResultBean, i.getCode()) >1).collect(Collectors.toSet());
//
//		subBusinessLinesDuplicateNature.stream().forEach(System.out::println);

        final Map<String, List<String>> myBeanGroupBy = listResultBean.stream().collect(
                Collectors.groupingBy(MyBean::getCode, Collectors.mapping(MyBean::getNature, Collectors.toList())));

        // Map<String, List<MyBean>> myBeanGroupBy2 =
        // listResultBean.stream().collect(Collectors.groupingBy(MyBean::getCode,Collectors.mapping(MyBean::getNature,
        // Collectors.toList())));

        final Map<String, Map<String, List<MyBean>>> map = listResultBean.stream().collect(
                Collectors.groupingBy(
                        MyBean::getCode,
                        Collectors.toMap(MyBean::getNature, Function.identity().toList())));

//        final Map<String, Map<String, MyBean>> map = listResultBean.stream().collect(
//                Collectors.groupingBy(MyBean::getCode, Collectors.toMap(MyBean::getNature, Function.identity())));

        final Map<String, Long> counting = listResultBean.stream().collect(
                Collectors.groupingBy(MyBean::getCode, Collectors.counting()));

        System.out.println(counting);

        // Map<String, String> sum = listResultBean.stream().collect(Collectors.groupingBy(MyBean::getCode,
        // Collectors.groupingBy(MyBean::getNature)));

//
    }

}
