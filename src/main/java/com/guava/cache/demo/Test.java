package com.guava.cache.demo;

import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.collect.*;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.AbstractPlatformTransactionManager;

import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by heshuanglin on 2017/11/28.
 */
public class Test {

    public static void main(String args[]){
        BiMap<Integer,String> map = HashBiMap.create();

        map.put(1,"a");
        map.put(2,"b");
        map.put(2,"a");

        System.out.println(map.inverse().get("a"));

//        Optional optional = Optional.fromNullable(123);
//
//
//        Multiset multiset = HashMultiset.create();
//
//        multiset.add("a");
//        multiset.add("b");
//        multiset.add("c");
//        multiset.add("a");
//        multiset.add("b");
//        multiset.add("c");
//
//
//        Iterator iterator =  multiset.iterator();
//       while (iterator.hasNext()){
//           System.out.println(iterator.next());
//       }
//
//        Set set = multiset.elementSet();
//
//       Iterator se =  set.iterator();
//
//        while (se.hasNext()){
//            System.out.println(se.next());
//        }
//
//
//        System.out.println(optional.isPresent());
//
//        System.out.println(optional.orNull());

//        ThreadLocal<String> threadLocal = new ThreadLocal();
//
//        threadLocal.set("主线程");
//
//        threadLocal.set("重新设置主线程");
//
//
//        List<Thread> threads = new ArrayList<>(20);
//        for (int i = 0;i<20;i++){
//            final  int x = i;
//            Thread thread = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println("当前执行线程："+x);
//                    System.out.println("threadLocal.get() :"+threadLocal.get());
//                    threadLocal.set(String.valueOf(x));
//                    System.out.println("threadLocal.get() :"+threadLocal.get());
//                }
//            });
//            threads.add(thread);
//            thread.start();
//
//        }
//
//        for (Thread thread:threads){
//            try {
//                thread.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//        System.out.println("主线程get："+threadLocal.get());



//          String mm = "402887c260e7dab20160e830274e4356";
//
//        String[] ids = mm.split(";");
//        StringBuffer idIn = new StringBuffer();
//        for (String id :ids) {
//            idIn.append(id+",");
//        }
//        idIn.deleteCharAt(idIn.length()-1);
//
//        System.out.println(idIn.toString());
//        Enhancer enhancer = new Enhancer();
//        enhancer.setSuperclass(CglibTest.class);
//        enhancer.setCallback(new Cglib());
//
//        CglibTest proxy = (CglibTest) enhancer.create();
//
//        proxy.call();






//        List<String> names = Arrays.asList("hjks","jklek","w");
//
//        Collections.sort(names,(first,second)->first.length()-second.length());
//        names.stream().filter(name->name.length()>0).forEach(System.out::println);
//
//        TreeMap<String,String> map = new TreeMap<String,String>();
//        map.put("","");
//        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
//        System.out.println(maxSubArray(nums));


//        List<String> list = new ArrayList<>();
//        list.add("A");
//        list.add("B");
//        list.add("C");
//        list.add("D");
//        list.add("E");
//        Optional optional = list.stream().findFirst();
//        System.out.println(optional.get());
//        list.stream().map(String::toLowerCase).limit(3).skip(1).forEach(System.out::println);
//        System.out.println(list.stream().distinct().limit(3).skip(2).collect(Collectors.toList()));
//        GuavaCache guavaCache = new GuavaCache();
//        System.out.println("使用loadingCache");
//        guavaCache.initLoadingCache();

    }

    public static int maxSubArray(int[] A) {
        int maxSoFar=A[0], maxEndingHere=A[0];
        for (int i=1;i<A.length;++i){
            maxEndingHere= Math.max(maxEndingHere+A[i],A[i]);
            maxSoFar=Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }


    public static int climb_Stairs(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climb_Stairs(i + 1, n) + climb_Stairs(i + 2, n);
    }
}
