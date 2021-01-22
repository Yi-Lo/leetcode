package solution.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yi-Lo
 * 2021/1/22 21:46
 * @version 1.0
 * @topics Hash Table、Math
 * @urllink https://leetcode-cn.com/problems/count-primes/
 */
public class P204_Count_Primes {

    public static int countPrimes_s1(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            count += isPrime(i) ? 1 : 0;
        }
        return count;
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static int countPrimes_s2(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i] == 1) {
                count++;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return count;
    }

    public static int countPrimes_s3(int n) {
        List<Integer> primes = new ArrayList<>();
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        for (int i = 2; i < n; i++) {
            if (isPrime[i] == 1) {
                primes.add(i);
            }
            for (int j = 0; j < primes.size() && i * primes.get(j) < n; j++) {
                isPrime[i * primes.get(j)] = 0;
                if (i % primes.get(j) == 0) break;
            }
        }
        return primes.size();
    }

    public static int countPrimes_s4(int n) {
        if (n < 3) return 0;
        int count = n >> 1;
        boolean[] notPrimes = new boolean[n];
        for (int i = 3; i * i < n; i += 2) {
            if (!notPrimes[i]) {
                for (int j = i * i; j < n; j += (i << 1)) {
                    if (!notPrimes[j]) {
                        count--;
                        notPrimes[j] = true;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPrimes_s1(50));
        System.out.println(countPrimes_s2(50));
        System.out.println(countPrimes_s3(50));
        System.out.println(countPrimes_s4(50));
    }
}