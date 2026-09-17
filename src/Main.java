enum SwitchType { RED, BLUE, BROWN, MEMBRANE }
enum KeycapMaterial { ABS, PBT }
enum SizeLayout { FULL_SIZE, TKL, SIXTY_PERCENT }

class Keyboard {
    private SwitchType switchType;
    private KeycapMaterial keycaps;
    private SizeLayout layout;
    private boolean hasRGB;
    private boolean isWireless;

    public Keyboard(SwitchType switchType, KeycapMaterial keycaps,
                    SizeLayout layout, boolean hasRGB, boolean isWireless) {
        this.switchType = switchType;
        this.keycaps = keycaps;
        this.layout = layout;
        this.hasRGB = hasRGB;
        this.isWireless = isWireless;
    }

    @Override
    public String toString() {
        return "Keyboard{" +
                "switchType=" + switchType +
                ", keycaps=" + keycaps +
                ", layout=" + layout +
                ", hasRGB=" + hasRGB +
                ", isWireless=" + isWireless +
                '}';
    }
}

interface KeyboardBuilder {
    KeyboardBuilder setSwitchType(SwitchType type);
    KeyboardBuilder setKeycaps(KeycapMaterial material);
    KeyboardBuilder setLayout(SizeLayout layout);
    KeyboardBuilder setRGB(boolean hasRGB);
    KeyboardBuilder setWireless(boolean isWireless);
    Keyboard build();
}

class MechanicalBuilder implements KeyboardBuilder {
    private SwitchType switchType;
    private KeycapMaterial keycaps;
    private SizeLayout layout;
    private boolean hasRGB;
    private boolean isWireless;

    @Override
    public KeyboardBuilder setSwitchType(SwitchType type) {
        this.switchType = type;
        return this;
    }

    @Override
    public KeyboardBuilder setKeycaps(KeycapMaterial material) {
        this.keycaps = material;
        return this;
    }

    @Override
    public KeyboardBuilder setLayout(SizeLayout layout) {
        this.layout = layout;
        return this;
    }

    @Override
    public KeyboardBuilder setRGB(boolean hasRGB) {
        this.hasRGB = hasRGB;
        return this;
    }

    @Override
    public KeyboardBuilder setWireless(boolean isWireless) {
        this.isWireless = isWireless;
        return this;
    }

    @Override
public Keyboard build() {
    if (switchType == null || keycaps == null || layout == null) {
        throw new IllegalStateException(
                "Switch type, keycaps and layout must be set"
        );
    }

    if (switchType == SwitchType.MEMBRANE) {
        throw new IllegalArgumentException(
                "Mechanical keyboards cannot use membrane switches"
        );
    }

    return new Keyboard(switchType, keycaps, layout, hasRGB, isWireless);
}

class OfficeBuilder implements KeyboardBuilder {
    private SwitchType switchType = SwitchType.MEMBRANE;
    private KeycapMaterial keycaps = KeycapMaterial.ABS;
    private SizeLayout layout = SizeLayout.FULL_SIZE;
    private boolean hasRGB = false;
    private boolean isWireless = true;

    @Override
    public KeyboardBuilder setSwitchType(SwitchType type) {
        this.switchType = type;
        return this;
    }

    @Override
    public KeyboardBuilder setKeycaps(KeycapMaterial material) {
        this.keycaps = material;
        return this;
    }

    @Override
    public KeyboardBuilder setLayout(SizeLayout layout) {
        this.layout = layout;
        return this;
    }

    @Override
    public KeyboardBuilder setRGB(boolean hasRGB) {
        this.hasRGB = hasRGB;
        return this;
    }

    @Override
    public KeyboardBuilder setWireless(boolean isWireless) {
        this.isWireless = isWireless;
        return this;
    }

    @Override
    public Keyboard build() {
        if (hasRGB) {
            System.out.println("Office keyboards don't have RGB");
        }
        return new Keyboard(switchType, keycaps, layout, hasRGB, isWireless);
    }
}

class KeyboardDirector {
    public Keyboard makeGamingRig(KeyboardBuilder builder) {
        return builder.setLayout(SizeLayout.TKL)
                .setSwitchType(SwitchType.RED)
                .setKeycaps(KeycapMaterial.PBT)
                .setRGB(true)
                .setWireless(false)
                .build();
    }

    public Keyboard makeStandardOffice(KeyboardBuilder builder) {
        return builder.setLayout(SizeLayout.FULL_SIZE)
                .setSwitchType(SwitchType.MEMBRANE)
                .setKeycaps(KeycapMaterial.ABS)
                .setRGB(false)
                .setWireless(true)
                .build();
    }
}

public class Main {
    public static void main(String[] args) {
        KeyboardDirector director = new KeyboardDirector();
        KeyboardBuilder mechBuilder = new MechanicalBuilder();
        Keyboard gamingKeyboard = director.makeGamingRig(mechBuilder);
        System.out.println("Gaming PC Setup: " + gamingKeyboard);
        KeyboardBuilder officeBuilder = new OfficeBuilder();
        Keyboard customOffice = officeBuilder.setLayout(SizeLayout.SIXTY_PERCENT)
                .setWireless(true)
                .build();

        System.out.println("Custom Office Setup: " + customOffice);
    }
}
