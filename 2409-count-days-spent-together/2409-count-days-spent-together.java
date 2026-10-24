class Solution {
    private int[] days = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        String start = arriveAlice.compareTo(arriveBob) < 0 ? arriveBob : arriveAlice;
        String end = leaveAlice.compareTo(leaveBob) < 0 ? leaveAlice : leaveBob;

        int startDayOfYear = convertToDayOfYear(start);
        int endDayOfYear = convertToDayOfYear(end);
        return Math.max(endDayOfYear - startDayOfYear + 1, 0);
    }

    private int convertToDayOfYear(String dateString) {
        int month = Integer.parseInt(dateString.substring(0, 2));
        int day = Integer.parseInt(dateString.substring(3, 5));
        
        int totalDays = 0;
        for (int i = 0; i < month - 1; i++) {
            totalDays += days[i];
        }
        totalDays += day;
        return totalDays;
    }
}
