import graph.AdjacentMatrixGraph;
import graph.Graph;
import graph.ToplogicalSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExamSchedule {

    public static void main(String[] args) {

        List<String> Courses = new ArrayList<>();
        Courses.add("CS100");
        Courses.add("CS101");
        Courses.add("CS102");
        Courses.add("CS103");
        Courses.add("CS104");
        Courses.add("CS105");

        Map<String, List<String>> prereqs = new HashMap<>();

        List<String> list = new ArrayList<>();

        list.add("CS101");
        list.add("CS102");
        list.add("CS103");
        prereqs.put("CS100", list);

        list = new ArrayList<>();
        list.add("CS104");
        prereqs.put("CS102", list);

        list = new ArrayList<>();
        list.add("CS105");
        prereqs.put("CS103", list);

        Graph graph = new AdjacentMatrixGraph(Courses.size(), Graph.GRAPH_TYPE.DIRECTED);

        Map<String, Integer> courseIdMap = new HashMap<>();

        for (int i = 0; i < Courses.size(); i++) {
            courseIdMap.put(Courses.get(i), i);
        }

        Map<Integer, String> idCourseMap = new HashMap<>();
        for (int i = 0; i < Courses.size(); i++) {
            idCourseMap.put(i, Courses.get(i));
        }

        prereqs.forEach((prereq, course) -> {
            course.forEach(singleCourse -> graph.addWeightedEdge(courseIdMap.get(prereq), courseIdMap.get(singleCourse)));
        });

        ToplogicalSort top = new ToplogicalSort();
        List<Integer> sortedId = top.sort(graph);

        sortedId.forEach(id -> System.out.println(idCourseMap.get(id)));
    }
}
