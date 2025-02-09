//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
            
            for(int i=0; i<N-1; i++)
            {
                ArrayList<Integer> temp = new ArrayList<>();
                String S[] = read.readLine().split(" ");
                temp.add(Integer.parseInt(S[0]));
                temp.add(Integer.parseInt(S[1]));
                arr.add(temp);
            }

            Solution ob = new Solution();
            System.out.println(ob.maxBinTreeGCD(arr,N));
        
System.out.println("~");
}
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static int maxBinTreeGCD(ArrayList<ArrayList<Integer>> arr, int N) {
        // code here
        if (N == 0) return 0;
        Map<Integer, List<Integer>> childrenMap = new HashMap<>();
        
        for (ArrayList<Integer> edge : arr) {
            int parent = edge.get(0);
            int child = edge.get(1);
            
            childrenMap.putIfAbsent(parent, new ArrayList<>());
            childrenMap.get(parent).add(child);
        }
        
        int maxGcd = 0;
        
        for (Map.Entry<Integer, List<Integer>> entry : childrenMap.entrySet()) {
            List<Integer> children = entry.getValue();
            
            if (children.size() > 1) {
                Collections.sort(children);
                
                for (int i = 1; i < children.size(); i++) {
                    int gcdValue = gcd(children.get(i), children.get(i-1));
                    maxGcd = Math.max(maxGcd, gcdValue);
                }
            }
        }
        return maxGcd;
    }
    
    private static int gcd (int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
};
