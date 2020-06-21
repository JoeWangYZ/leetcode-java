package contest.weeklycontest183;

public class NumSteps {
  public int numSteps(String s) {
    char[] schars = s.toCharArray();
    int n = schars.length;
    float sum = 0;
    float r = 1;
    for (int i = n - 1; i >= 0; i --) {
      sum += ((schars[i] - '0') * r);
      r *= 2;
    }
    int step = 0;
    while (sum != 1) {
      if (sum % 2 == 0) {
        sum /= 2;
      } else {
        sum += 1;
      }
      step ++;
    }
    return step;
  }

  public static void main(String[] args) {
    String s = "1111011110000011100000110001011011110010111001010111110001";
    NumSteps numSteps = new NumSteps();
    numSteps.numSteps(s);
  }
}
