package com.company.s24984_p02;

import java.util.Objects;
import java.util.Scanner;

public class S24984_p02 {

            public static void main(String[] args) {
                System.out.println("Kontynujemy gre (c) czy zaczynamy nowa (n)? ");
                Scanner scant = new Scanner(System.in);
                String odp = scant.nextLine();

                if (Objects.equals(odp, "c")) {

                } else if (Objects.equals(odp, "n")) {
                    iloscPlayer();

                    if (graczI > 4 || graczI < 2) {
                        System.out.println("Zle podana wartosc");
                    } else {

                        randomPlayer();

                        while ((graczI == 2 && sum2 > 1) || (graczI == 3 && sum3 > 2) || (graczI == 4 && sum4 > 3)) {
                            if (qeque[0] == 2) {
                                if (pionekRPole == 0) {
                                    wychodzenieZDomkuStart();
                                } else {
                                    Move();
                                }
                            } else if (qeque[1] == 2) {
                                if (pionekBPole == 0) {
                                    wychodzenieZDomkuStart();
                                } else {
                                    Move();
                                }
                            } else if (qeque[2] == 2) {
                                if (pionekGPole == 0) {
                                    wychodzenieZDomkuStart();
                                } else {
                                    Move();
                                }
                            } else if (qeque[3] == 2) {
                                if (pionekYPole == 0) {
                                    wychodzenieZDomkuStart();
                                } else {
                                    Move();
                                }
                            }
                        }
                    }
                } else {
                    System.out.println("Zle wprowadzone dane");
                }

            }

            ////////////////////////////
//11= ╚  12= ╔  13= ╝  14= ╗  15= ═ 16= ║
//0=x
//1=r
//2=b
//3=g
//4=y
//5=▒start
//6= ■
//20=30    21=20   22=0   23=10
//99=puste
            public static int[] qeque = new int[3];//0-red; 1-blue; 2-green; 3-yellow;
            public static int[][] x4x4 = new int[][]{
                    {12, 15, 15, 15, 15, 15, 15, 22, 15, 15, 15, 15, 14},
                    {16, 101, 102, 99, 99, 0, 0, 5, 99, 99, 201, 202, 16},
                    {16, 103, 104, 99, 99, 0, 6, 0, 99, 99, 203, 204, 16},
                    {16, 99, 99, 99, 99, 0, 6, 0, 99, 99, 99, 99, 16},
                    {16, 99, 99, 99, 99, 0, 6, 0, 99, 99, 99, 99, 16},
                    {20, 5, 0, 0, 0, 0, 6, 0, 0, 0, 0, 0, 16},
                    {16, 0, 6, 6, 6, 6, 99, 6, 6, 6, 6, 0, 16},
                    {16, 0, 0, 0, 0, 0, 6, 0, 0, 0, 0, 5, 23},
                    {16, 99, 99, 99, 99, 0, 6, 0, 99, 99, 99, 99, 16},
                    {16, 99, 99, 99, 99, 0, 6, 0, 99, 99, 99, 99, 16},
                    {16, 401, 402, 99, 99, 0, 6, 0, 99, 99, 301, 302, 16},
                    {16, 403, 404, 99, 99, 5, 0, 0, 99, 99, 303, 304, 16},
                    {11, 15, 15, 15, 15, 21, 15, 15, 15, 15, 15, 15, 13}
            };

            public static int[] mapa = new int[40];

            {
                mapa[0] = x4x4[1][7];
                mapa[1] = x4x4[2][7];
                mapa[2] = x4x4[3][7];
                mapa[3] = x4x4[4][7];
                mapa[4] = x4x4[5][7];
                mapa[5] = x4x4[5][8];
                mapa[6] = x4x4[5][9];
                mapa[7] = x4x4[5][10];
                mapa[8] = x4x4[5][11];
                mapa[9] = x4x4[6][11];
                mapa[10] = x4x4[7][11];
                mapa[11] = x4x4[7][10];
                mapa[12] = x4x4[7][9];
                mapa[13] = x4x4[7][8];
                mapa[14] = x4x4[7][7];
                mapa[15] = x4x4[8][7];
                mapa[16] = x4x4[9][7];
                mapa[17] = x4x4[10][7];
                mapa[18] = x4x4[11][7];
                mapa[19] = x4x4[11][6];
                mapa[20] = x4x4[11][5];
                mapa[21] = x4x4[10][5];
                mapa[22] = x4x4[9][5];
                mapa[23] = x4x4[8][5];
                mapa[24] = x4x4[7][5];
                mapa[25] = x4x4[7][4];
                mapa[26] = x4x4[7][3];
                mapa[27] = x4x4[7][2];
                mapa[28] = x4x4[7][1];
                mapa[29] = x4x4[6][1];
                mapa[30] = x4x4[5][1];
                mapa[31] = x4x4[5][2];
                mapa[32] = x4x4[5][3];
                mapa[33] = x4x4[5][4];
                mapa[34] = x4x4[5][5];
                mapa[35] = x4x4[4][5];
                mapa[36] = x4x4[3][5];
                mapa[37] = x4x4[2][5];
                mapa[38] = x4x4[1][5];
                mapa[39] = x4x4[1][6];
            }

            public static int wygranoR = 0;//czy wygraw gracz
            public static int wygranoB = 0;
            public static int wygranoG = 0;
            public static int wygranoY = 0;

            public static int sum2 = wygranoR + wygranoB;//znak stop gra
            public static int sum3 = wygranoR + wygranoB + wygranoG;
            public static int sum4 = wygranoR + wygranoB + wygranoG + wygranoY;

            public static int pionekR = 4;//ilosc pionkow w domku
            public static int pionekB = 4;
            public static int pionekG = 4;
            public static int pionekY = 4;

            public static int pionekRPole = 0;//ilosc pionkow na polu
            public static int pionekBPole = 0;
            public static int pionekGPole = 0;
            public static int pionekYPole = 0;

            public static int graczI;//ilosc graczy

            public static int nrPionka;//nr pionka

            public static int move;//move


            public static void iloscPlayer() {

                Scanner scan = new Scanner(System.in);
                System.out.println("Prosze podac ilosc graczow (2-4):");
                graczI = scan.nextInt();
            }


            public static void randomPlayer() {
                int fplayer = (int) ((Math.random() * graczI) + 1);

                if (graczI == 2) {//0-wygral lub niegra; 1-gra; 2-kostka;
                    qeque[0] = 1;
                    qeque[1] = 1;

                    qeque[fplayer] = 2;

                } else if (graczI == 3) {
                    qeque[0] = 1;
                    qeque[1] = 1;
                    qeque[2] = 1;

                    qeque[fplayer] = 2;

                } else if (graczI == 4) {
                    qeque[0] = 1;
                    qeque[1] = 1;
                    qeque[2] = 1;
                    qeque[3] = 1;

                    qeque[fplayer] = 2;

                }

                if (fplayer == 1) {
                    System.out.println("Pierwszym gra: RED (r)");
                    System.out.println();
                    System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
                } else if (fplayer == 2) {
                    System.out.println("Pierwszym gra: BLUE (b)");
                    System.out.println();
                    System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
                } else if (fplayer == 3) {
                    System.out.println("Pierwszym gra: YELLOW (y)");
                    System.out.println();
                    System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
                } else {
                    System.out.println("Pierwszym gra: GREEN (g)");
                    System.out.println();
                    System.out.println("▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄");
                }
            }

            public static void kolejkaPlayer() {

                final String ANSI_RESET = "\u001B[0m";
                final String ANSI_RED = "\u001B[31m";
                final String ANSI_YELLOW = "\u001B[33m";//public static
                final String ANSI_BLUE = "\u001B[34m";
                final String ANSI_GREEN = "\u001B[32m";

                if (qeque[0] == 2) {
                    if (pionekR == 0) {
                        qeque[0] = 0;
                        wygranoR++;

                        qeque[1] = 2;
                    } else {
                        System.out.print(ANSI_RED + "RED" + ANSI_RESET);
                        qeque[0] = 1;
                        qeque[1] = 2;
                    }

                } else if (qeque[1] == 2) {
                    if (pionekB == 0) {
                        qeque[1] = 0;
                        wygranoB++;

                        if (graczI == 2) {
                            qeque[0] = 2;
                        } else {
                            qeque[2] = 2;
                        }
                    } else {
                        System.out.print(ANSI_BLUE + "BLUE" + ANSI_RESET);
                        qeque[1] = 1;
                        if (graczI == 2) {
                            qeque[0] = 2;
                        } else {
                            qeque[2] = 2;
                        }
                    }

                } else if (qeque[2] == 3) {
                    if (pionekG == 0) {
                        qeque[2] = 0;
                        wygranoG++;

                        if (graczI == 3) {
                            qeque[0] = 2;
                        } else {
                            qeque[3] = 2;
                        }
                    } else {
                        System.out.print(ANSI_GREEN + "GREEN" + ANSI_RESET);
                        qeque[2] = 1;
                        if (graczI == 3) {
                            qeque[0] = 2;
                        } else {
                            qeque[3] = 2;
                        }
                    }

                } else if (qeque[3] == 4) {
                    if (pionekY == 0) {
                        qeque[3] = 0;
                        wygranoY++;

                        qeque[0] = 2;
                    } else {
                        System.out.print(ANSI_YELLOW + "YELLOW" + ANSI_RESET);

                        qeque[3] = 1;
                        qeque[0] = 2;
                    }

                }

            }


            public static void wychodzenieZDomkuStart() {
                int a = 0;
                int b = 1;

                do {
                    a++;
                    int los = (int) ((Math.random() * 6) + 1);
                    System.out.println();

                    System.out.println("Wylosowanie " + b + ": " + los);
                    System.out.println();
                    System.out.println("──────────────────────────────────────────────");
                    b++;

                    if (los == 6) {
                        a = 3;

                        if (qeque[0] == 2) {
                            pionekRPole++;
                            pionekR--;
                        } else if (qeque[1] == 2) {
                            pionekBPole++;
                            pionekB--;
                        } else if (qeque[2] == 2) {
                            pionekGPole++;
                            pionekG--;
                        } else if (qeque[3] == 2) {
                            pionekYPole++;
                            pionekY--;
                        }

                        Move();

                    } else if (a == 3) {

                        System.out.println();
                        System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");
                        System.out.println("\n");
                        System.out.print("▌ Prejscie kostki do: ");
                        kolejkaPlayer();
                        System.out.print(" ▐" + "\n");
                    }
                } while (a < 3);
            }

            public static void Move() {

                int a = 6, b, c = 0;

                move = (int) ((Math.random() * 6) + 1);

                if (move < 6) {
                    System.out.print("▌Chodzimy na: " + move);
                    System.out.print(" ▐" + "\n");
                    show();

                    System.out.println("Wprowadz nr pionka");
                    Scanner scan = new Scanner(System.in);
                    nrPionka = scan.nextInt();

                    System.out.println();

                    moveGraf();
                } else {
                    if (qeque[0] == 2 && pionekRPole >= 1 && pionekRPole <= 4) {
                        System.out.println("Chcesz wprowadzic nowy pionek (1-tak, 2-nie)");
                        Scanner scan = new Scanner(System.in);
                        int pff = scan.nextInt();
                        if (pff == 1) {
                            pionekRPole++;
                            pionekR--;
                            do {
                                b = (int) (Math.random() * 6);
                                c += b;

                            } while (b == 6);

                            move = a + move + c;
                            System.out.println();
                            System.out.print("▌ Chodzimy na: " + move);
                            System.out.print(" ▐" + "\n");
                            show();
                            System.out.println("Wprowadz nr pionka");
                            nrPionka = scan.nextInt();

                            moveGraf();
                        } else if (pff == 2) {
                            do {
                                b = (int) (Math.random() * 6);
                                c += b;

                            } while (b == 6);

                            move = a + move + c;
                            System.out.println();
                            System.out.print("▌ Chodzimy na: " + move);
                            System.out.print(" ▐" + "\n");
                            show();
                            System.out.println("Wprowadz nr pionka");
                            nrPionka = scan.nextInt();

                            moveGraf();
                        }
                    }

                }
            }

            public static void moveGraf() {
                if (qeque[0] == 2) {
                    if (nrPionka == 1) {
                        mapa[move] = 101;
                        nrPionka = 0;
                        x4x4[1][1] = 99;
                        System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");

                        System.out.println("\n");
                        System.out.print("▌ Prejscie kostki do: ");
                        kolejkaPlayer();
                        System.out.print(" ▐" + "\n");

                    } else if (nrPionka == 2) {
                        mapa[move] = 102;
                        nrPionka = 0;
                        x4x4[1][2] = 99;
                        System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");

                        System.out.println("\n");
                        System.out.print("▌ Prejscie kostki do: ");
                        kolejkaPlayer();
                        System.out.print(" ▐" + "\n");

                    } else if (nrPionka == 3) {
                        mapa[move] = 103;
                        nrPionka = 0;
                        x4x4[2][1] = 99;
                        System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");

                        System.out.println("\n");
                        System.out.print("▌ Prejscie kostki do: ");
                        kolejkaPlayer();
                        System.out.print(" ▐" + "\n");

                    } else if (nrPionka == 4) {
                        mapa[move] = 104;
                        nrPionka = 0;
                        x4x4[2][2] = 99;
                        System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");

                        System.out.println("\n");
                        System.out.print("▌ Prejscie kostki do: ");
                        kolejkaPlayer();
                        System.out.print(" ▐" + "\n");

                    }
                } else if (qeque[1] == 2) {

                    if (nrPionka == 1) {
                        mapa[move] = 201;
                        nrPionka = 0;
                        x4x4[1][10] = 99;
                        System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");

                        System.out.println("\n");
                        System.out.print("▌ Prejscie kostki do: ");
                        kolejkaPlayer();
                        System.out.print(" ▐" + "\n");

                    } else if (nrPionka == 2) {
                        mapa[move] = 202;
                        nrPionka = 0;
                        x4x4[1][11] = 99;
                        System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");

                        System.out.println("\n");
                        System.out.print("▌ Prejscie kostki do: ");
                        kolejkaPlayer();
                        System.out.print(" ▐" + "\n");

                    } else if (nrPionka == 3) {
                        mapa[move] = 203;
                        nrPionka = 0;
                        x4x4[2][10] = 99;
                        System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");

                        System.out.println("\n");
                        System.out.print("▌ Prejscie kostki do: ");
                        kolejkaPlayer();
                        System.out.print(" ▐" + "\n");

                    } else if (nrPionka == 4) {
                        mapa[move] = 204;
                        nrPionka = 0;
                        x4x4[2][11] = 99;
                        System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");

                        System.out.println("\n");
                        System.out.print("▌ Prejscie kostki do: ");
                        kolejkaPlayer();
                        System.out.print(" ▐" + "\n");

                    }
                } else if (qeque[2] == 2) {
                    if (nrPionka == 1) {
                        mapa[move] = 301;
                        nrPionka = 0;
                        x4x4[10][10] = 99;
                        System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");

                        System.out.println("\n");
                        System.out.print("▌ Prejscie kostki do: ");
                        kolejkaPlayer();
                        System.out.print(" ▐" + "\n");

                    } else if (nrPionka == 2) {
                        mapa[move] = 302;
                        nrPionka = 0;
                        x4x4[10][11] = 99;
                        System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");

                        System.out.println("\n");
                        System.out.print("▌ Prejscie kostki do: ");
                        kolejkaPlayer();
                        System.out.print(" ▐" + "\n");

                    } else if (nrPionka == 3) {
                        mapa[move] = 303;
                        nrPionka = 0;
                        x4x4[11][10] = 99;
                        System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");

                        System.out.println("\n");
                        System.out.print("▌ Prejscie kostki do: ");
                        kolejkaPlayer();
                        System.out.print(" ▐" + "\n");

                    } else if (nrPionka == 4) {
                        mapa[move] = 304;
                        nrPionka = 0;
                        x4x4[11][11] = 99;
                        System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");

                        System.out.println("\n");
                        System.out.print("▌ Prejscie kostki do: ");
                        kolejkaPlayer();
                        System.out.print(" ▐" + "\n");

                    }
                } else if (qeque[3] == 2) {
                    if (nrPionka == 1) {
                        mapa[move] = 401;
                        nrPionka = 0;
                        x4x4[10][1] = 99;
                        System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");

                        System.out.println("\n");
                        System.out.print("▌ Prejscie kostki do: ");
                        kolejkaPlayer();
                        System.out.print(" ▐" + "\n");

                    } else if (nrPionka == 2) {
                        mapa[move] = 402;
                        nrPionka = 0;
                        x4x4[10][2] = 99;
                        System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");

                        System.out.println("\n");
                        System.out.print("▌ Prejscie kostki do: ");
                        kolejkaPlayer();
                        System.out.print(" ▐" + "\n");

                    } else if (nrPionka == 3) {
                        mapa[move] = 403;
                        nrPionka = 0;
                        x4x4[11][1] = 99;
                        System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");

                        System.out.println("\n");
                        System.out.print("▌ Prejscie kostki do: ");
                        kolejkaPlayer();
                        System.out.print(" ▐" + "\n");

                    } else if (nrPionka == 4) {
                        mapa[move] = 404;
                        nrPionka = 0;
                        x4x4[11][2] = 99;
                        System.out.println("▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒");

                        System.out.println("\n");
                        System.out.print("▌ Prejscie kostki do: ");
                        kolejkaPlayer();
                        System.out.print(" ▐" + "\n");

                    }
                }
            }


            public static void show() {

                final String ANSI_RESET = "\u001B[0m";
                final String ANSI_RED = "\u001B[31m";
                final String ANSI_YELLOW = "\u001B[33m";//public static
                final String ANSI_BLUE = "\u001B[34m";
                final String ANSI_GREEN = "\u001B[32m";

                for (int i = 0; i < x4x4.length; i++) {
                    for (int j = 0; j < x4x4[i].length; j++) {

                        if (x4x4[i][j] == 11) {
                            System.out.print("  ╚");

                        } else if (x4x4[i][j] == 12) {
                            System.out.print("  ╔");

                        } else if (x4x4[i][j] == 13) {
                            System.out.print("╝");

                        } else if (x4x4[i][j] == 14) {
                            System.out.print("╗");

                        } else if (x4x4[i][j] == 15) {
                            System.out.print("═");

                        } else if (x4x4[i][j] == 16) {
                            System.out.print("  ║      ");

                        } else if (x4x4[i][j] == 0) {
                            System.out.print("x");

                        } else if (x4x4[i][j] == 101) {
                            System.out.print(ANSI_RED + "r1" + ANSI_RESET);

                        } else if (x4x4[i][j] == 102) {
                            System.out.print(ANSI_RED + "r2" + ANSI_RESET);

                        } else if (x4x4[i][j] == 103) {
                            System.out.print(ANSI_RED + "r3" + ANSI_RESET);

                        } else if (x4x4[i][j] == 104) {
                            System.out.print(ANSI_RED + "r4" + ANSI_RESET);

                        } else if (x4x4[i][j] == 201) {
                            System.out.print(ANSI_BLUE + "b1" + ANSI_RESET);

                        } else if (x4x4[i][j] == 202) {
                            System.out.print(ANSI_BLUE + "b2" + ANSI_RESET);

                        } else if (x4x4[i][j] == 203) {
                            System.out.print(ANSI_BLUE + "b3" + ANSI_RESET);

                        } else if (x4x4[i][j] == 204) {
                            System.out.print(ANSI_BLUE + "b4" + ANSI_RESET);

                        } else if (x4x4[i][j] == 301) {
                            System.out.print(ANSI_GREEN + "g1" + ANSI_RESET);

                        } else if (x4x4[i][j] == 302) {
                            System.out.print(ANSI_GREEN + "g2" + ANSI_RESET);

                        } else if (x4x4[i][j] == 303) {
                            System.out.print(ANSI_GREEN + "g3" + ANSI_RESET);

                        } else if (x4x4[i][j] == 304) {
                            System.out.print(ANSI_GREEN + "g4" + ANSI_RESET);

                        } else if (x4x4[i][j] == 401) {
                            System.out.print(ANSI_YELLOW + "y1" + ANSI_RESET);

                        } else if (x4x4[i][j] == 402) {
                            System.out.print(ANSI_YELLOW + "y2" + ANSI_RESET);

                        } else if (x4x4[i][j] == 403) {
                            System.out.print(ANSI_YELLOW + "y3" + ANSI_RESET);

                        } else if (x4x4[i][j] == 404) {
                            System.out.print(ANSI_YELLOW + "y4" + ANSI_RESET);

                        } else if (x4x4[i][j] == 5) {
                            if (x4x4[i][j - 1] == 20) {
                                System.out.print(ANSI_RED + "▒" + ANSI_RESET);
                            } else if (x4x4[i + 1][j] == 21) {
                                System.out.print(ANSI_YELLOW + "▒" + ANSI_RESET);
                            } else if (x4x4[i][j + 1] == 23) {
                                System.out.print(ANSI_GREEN + "▒" + ANSI_RESET);
                            } else {
                                System.out.print(ANSI_BLUE + "▒" + ANSI_RESET);
                            }

                        } else if (x4x4[i][j] == 6) {
                            if (pionekR == 4 && i == 6 && j < 6) {
                                System.out.print("■");
                            } else if (pionekG == 4 && i == 6 && j > 6) {
                                System.out.print("■");
                            } else if (pionekB == 4 && i < 6 && j == 6) {
                                System.out.print("■");
                            } else if (pionekY == 4 && i > 6 && j == 6) {
                                System.out.print("■");
                            } else if (i == 6 && pionekR == 0 && j < 6) {
                                System.out.print(ANSI_RED + "■" + ANSI_RESET);

                            } else if (j == 6 && i < 6 && pionekB == 0) {
                                System.out.print(ANSI_BLUE + "■" + ANSI_RESET);

                            } else if (i == 6 && j > 6 && pionekG == 0) {
                                System.out.print(ANSI_GREEN + "■" + ANSI_RESET);

                            } else if (j == 6 && i > 6 && pionekY == 0) {
                                System.out.print(ANSI_YELLOW + "■" + ANSI_RESET);

                            } else if (i == 6 && j == 5 && pionekR == 3) {
                                System.out.print(ANSI_RED + "■" + ANSI_RESET);

                            } else if (i == 6 && j == 4 && pionekR == 2) {
                                System.out.print(ANSI_RED + "■" + ANSI_RESET);

                            } else if (i == 6 && j == 3 && pionekR == 1) {
                                System.out.print(ANSI_RED + "■" + ANSI_RESET);

                            } else if (i == 6 && j == 7 && pionekG == 3) {
                                System.out.print(ANSI_GREEN + "■" + ANSI_RESET);

                            } else if (i == 6 && j == 8 && pionekG == 2) {
                                System.out.print(ANSI_GREEN + "■" + ANSI_RESET);

                            } else if (i == 6 && j == 9 && pionekG == 1) {
                                System.out.print(ANSI_GREEN + "■" + ANSI_RESET);

                            } else if (i == 5 && j == 6 && pionekB == 3) {
                                System.out.print(ANSI_BLUE + "■" + ANSI_RESET);

                            } else if (i == 4 && j == 6 && pionekB == 2) {
                                System.out.print(ANSI_BLUE + "■" + ANSI_RESET);

                            } else if (i == 3 && j == 6 && pionekB == 1) {
                                System.out.print(ANSI_BLUE + "■" + ANSI_RESET);

                            } else if (i == 7 && j == 6 && pionekY == 3) {
                                System.out.print(ANSI_YELLOW + "■" + ANSI_RESET);

                            } else if (i == 8 && j == 6 && pionekY == 2) {
                                System.out.print(ANSI_YELLOW + "■" + ANSI_RESET);

                            } else if (i == 9 && j == 6 && pionekY == 1) {
                                System.out.print(ANSI_YELLOW + "■" + ANSI_RESET);

                            }


                        } else if (x4x4[i][j] == 20) {
                            System.out.print(" 30      ");

                        } else if (x4x4[i][j] == 21) {
                            System.out.print("  20     ");

                        } else if (x4x4[i][j] == 22) {
                            System.out.print("  0      ");

                        } else if (x4x4[i][j] == 23) {
                            System.out.print("  10  ");
                        } else {
                            System.out.print(" ");
                        }

                    }
                    System.out.println();
                }

            }

        }


