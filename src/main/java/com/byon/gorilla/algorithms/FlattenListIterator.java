package com.byon.gorilla.algorithms;

import java.util.*;

public class FlattenListIterator {

    public interface NestedInteger {

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger();

        // @retpublic class FlattenListIterator {
        //
        //    public interface NestedInteger {
        //
        //        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        //        public boolean isInteger();
        //
        //        // @return the single integer that this NestedInteger holds, if it holds a single integer
        //        // Return null if this NestedInteger holds a nested list
        //        public Integer getInteger();
        //
        //        // @return the nested list that this NestedInteger holds, if it holds a nested list
        //        // Return null if this NestedInteger holds a single integer
        //
        //        public List<NestedInteger> getList();
        //
        //    }
        //
        //    class NestedRef {
        //
        //        NestedInteger nestedInteger;
        //        int indexLast = 0;
        //
        //        public NestedRef(NestedInteger nestedInteger, int index) {
        //            this.nestedInteger = nestedInteger;
        //            this.indexLast = index;
        //        }
        //
        //    }
        //
        //    public class NestedIterator implements Iterator<Integer> {
        //
        //        Stack<NestedRef> stack = new Stack();
        //        List<NestedInteger> nestedList;
        //        List<Integer> result = new ArrayList<>();
        //        HashSet<NestedInteger> done = new HashSet();
        //        int resultIndex = 0;
        //
        //
        //        public NestedIterator(List<NestedInteger> nestedList) {
        //            this.nestedList = nestedList;
        //            createList();
        //        }
        //
        //        private void createList() {
        //            for (int i = 0; i < nestedList.size(); i++) {
        //
        //                int index = 0;
        //                NestedInteger curr = nestedList.get(i);
        //
        //                if (curr.isInteger()) {
        //                    result.add(curr.getInteger());
        //                } else {
        //
        //                    int currListIndex = 0;
        //
        //                    while(currListIndex < curr.getList().size() && curr.getList().get(currListIndex).isInteger()){
        //                        result.add(curr.getList().get(currListIndex).getInteger());
        //                        currListIndex++;
        //                    }
        //
        //                    if(currListIndex < curr.getList().size()){
        //                        stack.push(new NestedRef(curr, currListIndex));
        //                    }
        //                    else{
        //                        done.add(curr);
        //                    }
        //                }
        //            }
        //
        //            while (!stack.isEmpty()) {
        //                NestedRef top = stack.pop();
        //
        //                List<NestedInteger> children = top.nestedInteger.getList();
        //
        //
        //                while (done.contains(children.get(top.indexLast))) {
        //                    top.indexLast++;
        //                }
        //
        //                while (top.indexLast < children.size()) {
        //                    result.add(children.get(top.indexLast).getInteger());
        //                }
        //            }
        //        }
        //
        //        @Override
        //        public Integer next() {
        //            if(resultIndex < result.size()){
        //                Integer curr = result.get(resultIndex);
        //                resultIndex++;
        //                return curr;
        //            }
        //            return -1;
        //        }
        //
        //        @Override
        //        public boolean hasNext() {
        //            if(resultIndex < result.size()){
        //                return true;
        //            }
        //            return false;
        //        }
        //    }
        //
        //}urn the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer

        public List<NestedInteger> getList();

    }

    class NestedRef {

        NestedInteger nestedInteger;
        int indexLast = 0;

        public NestedRef(NestedInteger nestedInteger, int index) {
            this.nestedInteger = nestedInteger;
            this.indexLast = index;
        }

    }

    public class NestedIterator implements Iterator<Integer> {

        Stack<NestedRef> stack = new Stack();
        List<NestedInteger> nestedList;
        List<Integer> result = new ArrayList<>();
        HashSet<NestedInteger> done = new HashSet();
        int resultIndex = 0;


        public NestedIterator(List<NestedInteger> nestedList) {
            this.nestedList = nestedList;
            createList();
        }

        private void createList() {
            for (int i = 0; i < nestedList.size(); i++) {

                int index = 0;
                NestedInteger curr = nestedList.get(i);

                if (curr.isInteger()) {
                    result.add(curr.getInteger());
                } else {

                    int currListIndex = 0;

                    while(currListIndex < curr.getList().size() && curr.getList().get(currListIndex).isInteger()){
                        result.add(curr.getList().get(currListIndex).getInteger());
                        currListIndex++;
                    }

                    if(currListIndex < curr.getList().size()){
                        stack.push(new NestedRef(curr, currListIndex));
                    }
                    else{
                        done.add(curr);
                    }
                }
            }

            while (!stack.isEmpty()) {
                NestedRef top = stack.pop();

                List<NestedInteger> children = top.nestedInteger.getList();


                while (done.contains(children.get(top.indexLast))) {
                    top.indexLast++;
                }

                while (top.indexLast < children.size()) {
                    result.add(children.get(top.indexLast).getInteger());
                }
            }
        }

        @Override
        public Integer next() {
            if(resultIndex < result.size()){
                Integer curr = result.get(resultIndex);
                resultIndex++;
                return curr;
            }
            return -1;
        }

        @Override
        public boolean hasNext() {
            if(resultIndex < result.size()){
                return true;
            }
            return false;
        }
    }

}
