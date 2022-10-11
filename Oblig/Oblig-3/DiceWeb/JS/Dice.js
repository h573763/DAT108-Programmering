class Dice {
    #eyes;

    constructor(eyes = null){
        this.#eyes = eyes;
    }

    rollDice() {
        return Math.random(1, this.#eyes);
    }
}