class Solution {
    public String rankTeams(String[] votes) {
        Team[] teams = new Team[26];
        
        for(int i = 0; i < 26; ++i){
            teams[i] = new Team((char) (i + 'A'));
        }
        
        for(String vote : votes){
            for(int i = 0; i < vote.length(); ++i){
                char c = vote.charAt(i);
                teams[c - 'A'].votes[i]++;
            }
        }
        
        Arrays.sort(teams, new Comparator<Team>(){
            @Override
            public int compare(Team a, Team b){
                for(int i = 0; i < 26; ++i){
                    if(a.votes[i] != b.votes[i])
                        return b.votes[i] - a.votes[i];
                }
                
                return a.name - b.name;
            }
        });
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < votes[0].length(); ++i){
            sb.append(teams[i].name);
        }
        
        return sb.toString();
    }
}

class Team {
    char name;
    int[] votes;
    
    public Team(char name){
        this.name = name;
        this.votes = new int[26];
    }
}