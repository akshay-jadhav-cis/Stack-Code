import java.util.*;
public class Stack1 {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    static class LL{
        static Node head;
        public static boolean  isEmpty(){
            return head==null;
        }
        public static void push(int data){
            Node newnode=new Node(data);
            if(isEmpty()){
                head=newnode;
                return;
            }
           newnode.next=head;
           head=newnode;
        }
        public static int pop(){
            if(isEmpty()){
                return -1;
            }
            int top=head.data;
            head=head.next;
            return top;
        }
        public static int peek(){
             if(isEmpty()){
                return -1;
            }return head.data;
        }
    }
    static class Stack11{
    static ArrayList<Integer> s2=new ArrayList<>();
    public static boolean isEmpty(){
        return s2.size()==0;
    }
    public static void push(int data){
        s2.add(data);
    }
    public static int pop(){
        if(isEmpty()){
            return -1;
        }
        int top=s2.get(s2.size()-1);
        s2.remove(s2.size()-1);
        return top;
    }
    public static int peek(){
        if(isEmpty()){
            return -1;
        }
        return s2.get(s2.size()-1);
    }
    }
    public static String revString(String str){
        Stack<Character> s1=new Stack<>();
        for(int i=0;i<str.length();i++){
            s1.push(str.charAt(i));
        }
        StringBuilder sb=new StringBuilder();
        while(!s1.isEmpty()){
            System.out.print(s1.peek())
            ;
            s1.pop();
        }
        return sb.toString();
    }
    public static void nextGraeter(int arr[],int nxt[]){
        Stack<Integer> s1=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(!s1.isEmpty() && arr[s1.peek()]<=arr[i]){
                s1.pop();
            }
            if(s1.isEmpty()){
                nxt[i]=-1;
            }else{
                nxt[i]=arr[s1.peek()];
            }
            s1.push(i);
        }
    }
    public static void stockspan(int stocks[],int span[]){
        Stack<Integer>s1=new Stack<>();
        span[0]=1;
        s1.push(0);
        for(int i=1;i<span.length;i++){
            int currprice = stocks[i];
            while(  !s1.isEmpty() &&  currprice>stocks[s1.peek()]){
                s1.pop();
            }
            if(s1.isEmpty()){
                span[i]=i+1;
            }else{
                int prevHigh=s1.peek();
                span[i]=i-prevHigh;
            }
            s1.push(i);
        }
    }

    public static int maxAreaHistogram(int arr[]){
        int maxArea=0;
        int nsl[]=new int[arr.length];
        int nsr[]=new int[arr.length];
        Stack<Integer>s1=new Stack<>();
        //Next Smaller right
        for(int i=arr.length-1;i>=0;i--){
            while(!s1.isEmpty() && arr[s1.peek()]>=arr[i]){
                s1.pop();
            }
            if(s1.isEmpty()){
                nsr[i]=arr.length;
            }
            else{
                nsr[i]=arr[s1.peek()];
            }
            s1.push(i);
        }
        for(int i=0;i<nsr.length;i++){
            System.out.print(nsr[i]+"   ");
        }
        s1=new Stack<>();
        //next Smaller Left
         for(int i=0;i<arr.length;i++){
            while(!s1.isEmpty() && arr[s1.peek()]>=arr[i]){
                s1.pop();
            }
            if(s1.isEmpty()){
                nsl[i]=-1;
            }
            else{
                nsl[i]=s1.peek();
            }
            s1.push(i);
        }
        System.out.println();
        for(int i=0;i<nsl.length;i++){
            System.out.print(nsl[i]+"   ");
        }
        for(int i=0;i<arr.length;i++){
            int width=nsr[i]-nsl[i]-1;
            maxArea=Math.max(maxArea,arr[i]*width);
        }
        System.out.println();
        return maxArea; 
    }
    public static void main(String[] args) {
        Stack s1=new Stack();
        s1.push(1);
        s1.push(2);
        s1.push(3);
        while(!s1.isEmpty()){
            System.out.println(s1.peek());
            s1.pop();
        }
        LL l1=new LL();
        l1.push(1);
        l1.push(2);
        l1.push(3); 
        while(!l1.isEmpty()){
            System.out.println(l1.peek());
            l1.pop();
        }



        //Revese String
        System.out.println(revString("akshay"));
        int stocks[]={100,80,60,70,60,85,100};
        int span[]=new int[stocks.length];
        stockspan(stocks, span);
        for(int e:span){
            System.out.print(e);
        }
        System.out.println();
        int arr[]=new int[stocks.length];
        nextGraeter(stocks, arr);
        for(int e:arr){
            System.out.print(e+"    ");
        }
        int arr1[]={2,4};
        System.out.println(maxAreaHistogram(arr1));
    }
}
