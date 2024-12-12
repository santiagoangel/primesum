// Java program to count subarrays 
// with Prime sum 
class GFG 
{
  
    // Function to count subarrays 
    // with Prime sum 
    static int primeSubarrays(int[] A, int n) 
    { 
        int max_val = 10000000;
    
        // USE SIEVE TO FIND ALL PRIME NUMBERS LESS 
        // THAN OR EQUAL TO max_val 
        // Create a boolean array "prime[0..n]". A 
        // value in prime[i] will finally be false 
        // if i is Not a prime, else true. 
        boolean[] prime = new boolean[max_val + 1]; 
    
        
        //initialize initial value
        for (int p = 0; p < max_val + 1; p++)
        prime[p]=true;
    
        // Remaining part of SIEVE 
        prime[0]=false; 
        prime[1]=false; 
        for (int p = 2; p * p <= max_val; p++) { 
    
            // If prime[p] is not changed, then 
            // it is a prime 
            if (prime[p] == true) { 
    
                // Update all multiples of p 
                for (int i = p * 2; i <= max_val; i += p) 
                    prime[i]=false; 
            } 
        } 
    
        int cnt = 0; // Initialize result 
    
        // Traverse through the array 
        for (int i = 0; i <= n - 1; ++i) { 
            int val = A[i]; 
            if (prime[val]) 
                    cnt++; 
            for (int j = i + 1; j < n; ++j) { 
                val += A[j]; 
    
                if (prime[val]) 
                    ++cnt; 
            } 
        } 
    
        // return answer 
        return cnt; 
    }
    
    //Driver code
    public static void main(String[] args) {
        int[] A = { 3,7,4,5 }; 
        int n = A.length; 
    
        System.out.println(primeSubarrays(A, n)); 
    }
}


//This code is contributed by phasing17 
//modified by Santiago Angel for count array of lenght 1

