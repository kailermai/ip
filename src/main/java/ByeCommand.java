public class ByeCommand extends Commands {
    private final Ui ui;

    public ByeCommand(Ui ui) {
        this.ui = ui;
    }

    @Override
    public void execute() {
        ui.printGoodbyeMessage();
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
