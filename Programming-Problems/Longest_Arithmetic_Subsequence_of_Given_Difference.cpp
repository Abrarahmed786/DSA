// Given an integer array arr and an integer difference, return the length of the longest subsequence in arr which is an arithmetic sequence such that the difference between adjacent elements in the subsequence equals difference.

// A subsequence is a sequence that can be derived from arr by deleting some or no elements without changing the order of the remaining elements.


class Solution {
public:
    int longestSubsequence(vector<int>& arr, int difference) {
         int n=arr.size();
        int len=0;
        
        map<int,int> m;
        
        for(int i=0;i<n;i++){
            if(m.find(arr[i]-difference)!=m.end()){
                m[arr[i]]=1+m[arr[i]-difference];
            }else{
                m[arr[i]]=1;
            }
            len=max(len,m[arr[i]]);
        } 
        
        return len; }
};
