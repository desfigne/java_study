package chapter06;

public class JAVA0699StudentScoreMgmS03Student {
    String studentId;
    String name;
    String major;
    int grade;
    int kor, eng, math;
    int tot;
    double avg;
    String gradeLetter;

    // 총점, 평균, 등급 계산
    public void calcScore() {
        tot = kor + eng + math;
        avg = tot / 3.0;
        if (avg >= 90) {
            gradeLetter = "A";
        } else if (avg >= 80) {
            gradeLetter = "B";
        } else if (avg >= 70) {
            gradeLetter = "C";
        } else if (avg >= 60) {
            gradeLetter = "D";
        } else if (avg >= 50) {
            gradeLetter = "E";
        } else {
            gradeLetter = "F";
        }
    }
}
