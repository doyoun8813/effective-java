package item55;

import item39.ExceptionTest;

import java.lang.annotation.Retention;
import java.util.Map;
import java.util.Optional;

public class ParentPid {

    public static void main(String[] args) {
        ProcessHandle ph = ProcessHandle.current();

        Optional<ProcessHandle> parentProcess = ph.parent();
        System.out.println("부모 PID: " + (parentProcess.isPresent() ? String.valueOf(parentProcess.get().pid()) : "N/A"));

        // 이 코드는 Optional의 map을 사용하여 다듬을 수 있다.
        System.out.println("부모 PID: " + ph.parent().map(processHandle -> String.valueOf(processHandle.pid())).orElse("N/A"));

    }
}
