package item55;

import java.util.Optional;

public class ParentPid {

    public static void main(String[] args) {
        ProcessHandle ph = ProcessHandle.current();

        Optional<ProcessHandle> parentProcess = ph.parent();
        System.out.println("�θ� PID: " + (parentProcess.isPresent() ? String.valueOf(parentProcess.get().pid()) : "N/A"));

        // �� �ڵ�� Optional�� map�� ����Ͽ� �ٵ��� �� �ִ�.
        System.out.println("�θ� PID: " + ph.parent().map(processHandle -> String.valueOf(processHandle.pid())).orElse("N/A"));
    }
}
