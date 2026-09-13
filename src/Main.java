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

