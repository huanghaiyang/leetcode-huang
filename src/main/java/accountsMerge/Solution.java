package accountsMerge;

import com.google.common.collect.Lists;

import java.util.*;

/**
 * created by huang 5/16/19
 */
public class Solution {

    public static void main(String[] args) {
        List<List<String>> lists = new ArrayList<>();
        lists.add(Lists.newArrayList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
        lists.add(Lists.newArrayList("John", "johnsmith@mail.com", "john00@mail.com"));
        lists.add(Lists.newArrayList("Mary", "mary@mail.com"));
        lists.add(Lists.newArrayList("John", "johnnybravo@mail.com"));
        new Solution().accountsMerge(lists);
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<Set>> map = new HashMap<>();
        for(List<String> account: accounts) {
            String accountName = account.get(0);
            Set<String> accountMails = new TreeSet<>(account.subList(1, account.size()));
            if(!map.keySet().contains(accountName)) {
                List<Set> accountList = new ArrayList<>();
                accountList.add(accountMails);
                map.put(accountName, accountList);
            }else {
                List<Set> listSet = map.get(accountName);
                List<Set> newListSet = new ArrayList<>();
                for(Set set : listSet) {
                    Set<String> tempSet = new TreeSet<>();
                    tempSet.addAll(set);
                    tempSet.addAll(accountMails);
                    if(tempSet.size() < set.size() + accountMails.size()) {
                        set.addAll(accountMails);
                        break;
                    }else {
                        newListSet.add(accountMails);
                    }
                }
                if(newListSet.size() != 0) {
                    listSet.addAll(newListSet);
                }
            }
        }
        // 反复检查是否有并集存在，若存在则合并
        for(String accountName: map.keySet()) {
            List<Set> listSet = map.get(accountName);
            while(checkListSet(listSet)) {
                for(int i = 1 ; i < listSet.size() ; i ++) {
                    if(checkListSetAndMerge(listSet.subList(0, i), listSet.get(i))) {
                        listSet.remove(i);
                        break;
                    }
                }
            }
        }
        List<List<String>> lists = new ArrayList<>();
        for(String accountName: map.keySet()) {
            for(Set<String> set: map.get(accountName)) {
                List<String> list = new ArrayList<>();
                list.add(accountName);
                list.addAll(set);
                lists.add(list);
            }
        }
        return lists;
    }

    public Boolean checkListSet(List<Set> listSet) {
        Set tempSet = new HashSet();
        int count = 0;
        for(Set set: listSet) {
            count += set.size();
            tempSet.addAll(set);
        }
        return tempSet.size() < count;
    }

    public Boolean checkListSetAndMerge(List<Set> listSet, Set set) {
        Boolean flag = false;
        for(Set item: listSet) {
            Set<String> tempSet = new TreeSet<>();
            tempSet.addAll(item);
            tempSet.addAll(set);
            if(tempSet.size() < set.size() + item.size()) {
                item.addAll(set);
                flag = true;
                break;
            }
        }
        return flag;
    }

}
