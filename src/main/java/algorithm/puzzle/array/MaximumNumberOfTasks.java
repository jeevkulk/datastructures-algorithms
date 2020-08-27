package algorithm.puzzle.array;

public class MaximumNumberOfTasks {
    /**
     * Given an array of integers, each representing time to complete that task,
     * need to complete maximum number of tasks in given time
     */
    private int getMaxNumberOfTasks(int[] tasks, int givenTime, int startingPos, int numberOfTasks) {
        if (givenTime <= 0) {
            return numberOfTasks;
        }
        if (startingPos >= tasks.length) {
            return numberOfTasks;
        }
        numberOfTasks = Math.max(
                tasks[startingPos] <= givenTime ? getMaxNumberOfTasks(tasks, givenTime - tasks[startingPos], startingPos + 1, numberOfTasks + 1) : 0,
                getMaxNumberOfTasks(tasks, givenTime, startingPos + 1, numberOfTasks)
        );
        return numberOfTasks;
    }

    public static void main(String[] args) {
        MaximumNumberOfTasks maximumNumberOfTasks = new MaximumNumberOfTasks();
        int givenTime = 5;
        int[] tasks = new int[]{6, 6, 6, 6, 5};
        System.out.println("Maximum number of tasks that can be completed in given time = "
                + maximumNumberOfTasks.getMaxNumberOfTasks(tasks, givenTime, 0,0));
    }
}
