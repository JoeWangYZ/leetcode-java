package contest.weeklycontest189;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PeopleIndexes {
  Map<String, List<Integer>> companyToIndexMap = new HashMap();
  int userCount = 0;
  public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
    List<Favorite> favorites = new ArrayList();
    userCount = favoriteCompanies.size();
    for (int i = 0; i < userCount; i ++) {
      List<String> favoriteCompany = favoriteCompanies.get(i);
      Favorite f = new Favorite(i);
      for (String company: favoriteCompany) {
        f.addCompany(company);
        List<Integer> indexList = companyToIndexMap.containsKey(company) ?
            companyToIndexMap.get(company) : new ArrayList();
        indexList.add(i);
        companyToIndexMap.put(company, indexList);
      }
      favorites.add(f);
    }
    List<Integer> result = new ArrayList();
    for (Favorite f : favorites) {
      if (f.isNotOthersSub()) {
        result.add(f.userId);
      }
    }
    return result;

  }

  private class Favorite {
    int userId;
    List<String> companies;
    public Favorite(int userId) {
      this.userId = userId;
      companies = new ArrayList();
    }

    public void addCompany(String company) {
      companies.add(company);
    }

    public boolean isNotOthersSub() {
      int[] memo = new int[userCount];
      Arrays.fill(memo, 0);
      for (String company : companies) {

        List<Integer> indexList = companyToIndexMap.get(company);
        if (indexList.size() == 1 && indexList.get(0) == userId) {
          return true;
        } else {
          for (int i = 0; i < indexList.size(); i ++) {
            if (i != userId) {
              memo[i] ++;
            }
          }
        }
      }
      for (int i = 0; i < userCount; i ++) {
        if (memo[i] >= companies.size()) {
          return false;
        }
      }
      return true;
    }
  }

  public static void main(String[] args) {
    PeopleIndexes peopleIndexes = new PeopleIndexes();

    double[][] doubles = new double[3][];
  }
}
