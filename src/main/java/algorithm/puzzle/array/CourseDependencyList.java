package algorithm.puzzle.array;

public class CourseDependencyList {
    public static void main(String[] args) {
        CourseDependencyList courseDependencyList = new CourseDependencyList();
        courseDependencyList.arrangeCourses();
    }

    /**
     * Arrange courses as per course pre-requisite - keeping the shortest course first.
     * It is assumed that shorter courses have smaller course id.
     *
     * Example:
     * Courses as defined in array {{4, 3}, {2, 3}, {1, 2, 3}} indicates that
     * 1. course 3 is dependent on 3
     * 2. course 2 is dependent on 3
     * 3. course 1 is dependent on 2 and course 2 is dependent on 3
     */
    public void arrangeCourses() {
        Course courseList = new Course();
        int[][] arrCourseSeries = new int[][]{{4, 3}, {2, 3}, {1, 2, 3}};
        int numberOfCourseSeries = arrCourseSeries.length;
    }

    private int[] mergeCourses(int[] mergedCourses, int[] courseSeries) {
        //TODO
        return mergedCourses;
    }

    class Course {
        int n;
        Course previous;
        Course next;

        public int getN() {
            return n;
        }

        public void setN(int n) {
            this.n = n;
        }

        public Course getPrevious() {
            return previous;
        }

        public void setPrevious(Course previous) {
            this.previous = previous;
        }

        public Course getNext() {
            return next;
        }

        public void setNext(Course next) {
            this.next = next;
        }
    }
}
