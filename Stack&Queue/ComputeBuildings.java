package Stack&Queue;

import java.util.*;

/*
We are given an array buildings of integers. Each item represents the height of a building on a skyline from left to right.

Here are the details:
The sun sits on the far left
A building is "blocked" from seeing the sun if there is a building to its left that is >= in height than itself

You should:
Return a revised list of the buildings with "blocked" buildings excluded
Maintain the relative order of the buildings as they stood in buildings
Represent each building by its original index in buildings (rather than by its value)

*/
public class ComputeBuildings {
    public List<Integer> getBuildingsWithAView(int[] buildings) {
        Stack<Integer> revisedBuildings = new Stack<Integer>();

        for (int i = buildings.length - 1; i >= 0; i--) {

            while (!revisedBuildings.isEmpty() && buildings[i] >= buildings[revisedBuildings.peek()]) {
                revisedBuildings.pop();
            }

            revisedBuildings.push(i);
        }

        Collections.reverse(revisedBuildings);
        return new ArrayList(revisedBuildings);
    }
}