import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TopVotedCandidate911 {

    /*
    In an election, the i-th vote was cast for persons[i] at time times[i].

Now, we would like to implement the following query function: TopVotedCandidate.q(int t) will return the number of the person that was leading the election at time t.

Votes cast at time t will count towards our query.  In the case of a tie, the most recent vote (among tied candidates) wins.



Example 1:

Input: ["TopVotedCandidate","q","q","q","q","q","q"], [[[0,1,1,0,0,1,0],[0,5,10,15,20,25,30]],[3],[12],[25],[15],[24],[8]]
Output: [null,0,1,1,0,0,1]
Explanation:
At time 3, the votes are [0], and 0 is leading.
At time 12, the votes are [0,1,1], and 1 is leading.
At time 25, the votes are [0,1,1,0,0,1], and 1 is leading (as ties go to the most recent vote.)
This continues for 3 more queries at time 15, 24, and 8.
     */

    /*
    解题思路：2个hashmap去储存leaderfrequency跟time时候的lead,还要一个值去记录当前的lead
     */
    Map<Integer, Integer> map=new HashMap<>();
    int[] times;
    public TopVotedCandidate911(int[] persons, int[] times) {

        this.times=times;
        Map<Integer, Integer> count=new HashMap<>();
        int lead=-1;
        for(int i=0; i<persons.length; i++){
            count.put(persons[i],count.getOrDefault(persons[i],0)+1);
            if(i==0 || (count.get(persons[i])>=count.get(lead))){
                lead=persons[i];
            }
            map.put(times[i],lead);
        }
    }

    public int q(int t) {
        int i= Arrays.binarySearch(times, t);
        return i<0 ? map.get(times[-i-2]):map.get(times[i]);

    }
}
