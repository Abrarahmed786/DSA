// In a project, you have a list of required skills req_skills, and a list of people. The ith person people[i] contains a list of skills that the person has.

// Consider a sufficient team: a set of people such that for every required skill in req_skills, there is at least one person in the team who has that skill. We can represent these teams by the index of each person.

// For example, team = [0, 1, 3] represents the people with skills people[0], people[1], and people[3].
// Return any sufficient team of the smallest possible size, represented by the index of each person. You may return the answer in any order.

// It is guaranteed an answer exists.


class Solution {
    public static int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int n = req_skills.length, m = people.size();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(req_skills[i], i);
        }
        int peoples[] = new int[m];
        for (int i = 0; i < m; i++) {
            List<String> p = people.get(i);
            int result = 0;
            for (String s : p) {
                result = result | (1 << map.get(s));
            }
            peoples[i] = result;
        }
        int[] dp = new int[1 << n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        int final_state = (1 << n) - 1;
        int[] preState = new int[1 << n];
        int[] pre = new int[1 << n];
        for (int i = 0; i < m; i++) {
            for (int j = final_state; j >= 0; j--) {
                if (dp[j] == -1) {
                    continue;
                }
                int state = j | peoples[i];
                if (dp[state] == -1 || dp[state] > dp[j] + 1) {
                    dp[state] = dp[j] + 1;
                    preState[state] = j;
                    pre[state] = i;
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        int state = final_state;
        while (state != 0) {
            res.add(pre[state]);
            state = preState[state];
        }
        int[] resu = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resu[i] = res.get(i);
        }
        return resu;
    }
}