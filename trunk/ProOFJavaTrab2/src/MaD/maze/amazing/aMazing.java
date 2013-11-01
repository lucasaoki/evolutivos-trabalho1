/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MaD.maze.amazing;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;
import java.util.Random;

/**
 *
 * @author lucasaoki
 */
public class aMazing {

    double OBJETIVOX = -28.9;
    double OBJETIVOY = 17.5;
    int TAM_IND = 60;

    int nOrigem;

    float avaliaV(Vertice vertices[], int individuo[], int print) {

        Vertice vObj = new Vertice(), vAtual = vertices[0];
        int i, p, c, acao, origem, adj;
        float dist, fit, soma = 0;
        Random rand = new Random(System.currentTimeMillis());

        i = 0;
        p = 0;
        origem = 1; //0-leste; 1-sul; 2-oeste; 3-norte.

        while ((objetivo(vAtual) == 0) && (i < TAM_IND)) {
            acao = individuo[i];
            adj = ehPossivel(origem, acao, vAtual);
            //printf("or: %d; acao: %d; vAtual: %d; adj: %d\n", origem, acao, vAtual.rotulo, adj);
            while (adj == -1) {
                acao = rand.nextInt() % 5;
                adj = ehPossivel(origem, acao, vAtual);
                //printf("or: %d; acao: %d; vAtual: %d; adj: %d\n", origem, acao, vAtual.rotulo, adj);
            }
            dist = distEuclidiana(vAtual, vertices[adj]);
            soma = soma + dist;
            if (acao == 3) // meia volta
            {
                soma = soma + dist;
            }
            vAtual = vertices[adj];
            if (print == 1) {
                //printf(" %d -> ", vAtual.rotulo);
            }
            individuo[i] = acao;
            origem = nOrigem;
            i++;
        }

        if (objetivo(vAtual) == 1) {
            fit = soma / 2;
        } else {
            vObj.x = OBJETIVOX;
            vObj.y = OBJETIVOY;
            fit = soma + 2 * distEuclidiana(vAtual, vObj);
        }

        if (print == 1) {
//            printf("\ntam da rota: %d\n", i);
//            printf("fitness: %f\n", fit);
        }
        return fit;
    }

    float distEuclidiana(Vertice v1, Vertice v2) {
        float q1, q2, la;
        q1 = (float) pow((v1.x - v2.x), 2);
        q2 = (float) pow((v1.y - v2.y), 2);
        la = (float) (sqrt(q1 + q2));
        return la;
    }

    int objetivo(Vertice v) {
        if (v.x > OBJETIVOX - 1 && v.x < OBJETIVOX + 1) {
            if (v.y > OBJETIVOY - 1 && v.y < OBJETIVOY + 1) {
                return 1;
            }
        }
        return 0;
    }

    int ehPossivel(int origem, int acao, Vertice vAtual) {
        int v = 0, i, ad;

        ad = 0;
        switch (origem) {
            case 0: //leste
                switch (acao) {
                    case 0: {
                        for (i = 0; i < 4; i++) {
                            if (vAtual.adjacentes[i] == -1) {
                                ad++;
                            }
                        }
                        if (ad < 2) {
                            v = vAtual.adjacentes[2]; //frente
                            nOrigem = 0;
                        } else {
                            v = -1;
                        }
                    }
                    break;
                    case 1: {
                        v = vAtual.adjacentes[1]; //esq
                        nOrigem = 3;
                    }
                    break;
                    case 2: {
                        v = vAtual.adjacentes[3]; //dir
                        nOrigem = 1;
                    }
                    break;
                    case 3: {
                        if (vAtual.adjacentes[2] == -1 && vAtual.adjacentes[1] == -1 && vAtual.adjacentes[3] == -1) {
                            v = vAtual.adjacentes[0]; //meia volta
                            nOrigem = 2;
                        } else {
                            v = -1;
                        }
                    }
                    break;
                    case 4: {
                        for (i = 0; i < 4; i++) {
                            if (vAtual.adjacentes[i] == -1) {
                                ad++;
                            }
                        }
                        if (ad >= 2) {
                            v = vAtual.adjacentes[2]; //frente
                            nOrigem = 0;
                        } else {
                            v = -1;
                        }
                    }
                    break;
                }
                break;
            case 1: //sul
                switch (acao) {
                    case 0: {
                        for (i = 0; i < 4; i++) {
                            if (vAtual.adjacentes[i] == -1) {
                                ad++;
                            }
                        }
                        if (ad < 2) {
                            v = vAtual.adjacentes[3]; //frente
                            nOrigem = 1;
                        } else {
                            v = -1;
                        }
                    }
                    break;
                    case 1: {
                        v = vAtual.adjacentes[2]; //esq
                        nOrigem = 0;
                    }
                    break;
                    case 2: {
                        v = vAtual.adjacentes[0]; //dir
                        nOrigem = 2;
                    }
                    break;
                    case 3: {
                        if (vAtual.adjacentes[3] == -1 && vAtual.adjacentes[2] == -1 && vAtual.adjacentes[0] == -1) {
                            v = vAtual.adjacentes[1]; //meia volta
                            nOrigem = 3;
                        } else {
                            v = -1;
                        }
                    }
                    break;
                    case 4: {
                        for (i = 0; i < 4; i++) {
                            if (vAtual.adjacentes[i] == -1) {
                                ad++;
                            }
                        }
                        if (ad >= 2) {
                            v = vAtual.adjacentes[3]; //frente
                            nOrigem = 1;
                        } else {
                            v = -1;
                        }
                    }
                    break;
                }
                break;
            case 2: //oeste
                switch (acao) {
                    case 0: {
                        for (i = 0; i < 4; i++) {
                            if (vAtual.adjacentes[i] == -1) {
                                ad++;
                            }
                        }
                        if (ad < 2) {
                            v = vAtual.adjacentes[0]; //frente
                            nOrigem = 2;
                        } else {
                            v = -1;
                        }
                    }
                    break;
                    case 1: {
                        v = vAtual.adjacentes[3]; //esq
                        nOrigem = 1;
                    }
                    break;
                    case 2: {
                        v = vAtual.adjacentes[1]; //dir
                        nOrigem = 3;
                    }
                    break;
                    case 3: {
                        if (vAtual.adjacentes[0] == -1 && vAtual.adjacentes[3] == -1 && vAtual.adjacentes[1] == -1) {
                            v = vAtual.adjacentes[2]; //meia volta
                            nOrigem = 0;
                        } else {
                            v = -1;
                        }
                    }
                    break;
                    case 4: {
                        for (i = 0; i < 4; i++) {
                            if (vAtual.adjacentes[i] == -1) {
                                ad++;
                            }
                        }
                        if (ad >= 2) {
                            v = vAtual.adjacentes[0]; //frente
                            nOrigem = 2;
                        } else {
                            v = -1;
                        }
                    }
                    break;
                }
                break;
            case 3: //norte
                switch (acao) {
                    case 0: {
                        for (i = 0; i < 4; i++) {
                            if (vAtual.adjacentes[i] == -1) {
                                ad++;
                            }
                        }
                        if (ad < 2) {
                            v = vAtual.adjacentes[1]; //frente
                            nOrigem = 3;
                        } else {
                            v = -1;
                        }
                    }
                    break;
                    case 1: {
                        v = vAtual.adjacentes[0]; //esq
                        nOrigem = 2;
                    }
                    break;
                    case 2: {
                        v = vAtual.adjacentes[2]; //dir
                        nOrigem = 0;
                    }
                    break;
                    case 3: {
                        if (vAtual.adjacentes[1] == -1 && vAtual.adjacentes[0] == -1 && vAtual.adjacentes[2] == -1) {
                            v = vAtual.adjacentes[3]; //meia volta
                            nOrigem = 1;
                        } else {
                            v = -1;
                        }
                    }
                    break;
                    case 4: {
                        for (i = 0; i < 4; i++) {
                            if (vAtual.adjacentes[i] == -1) {
                                ad++;
                            }
                        }
                        if (ad >= 2) {
                            v = vAtual.adjacentes[1]; //frente
                            nOrigem = 3;
                        } else {
                            v = -1;
                        }
                    }
                    break;
                }
                break;
        }
        return v;
    }

    void inicializaVertices(Vertice vertices[], int qtdVertices) {
        int i;

        for (i = 0; i < qtdVertices; i++) {
            vertices[i].rotulo = i;
        }
        vertices[0].adjacentes[0] = -1;
        vertices[0].adjacentes[1] = -1;
        vertices[0].adjacentes[2] = -1;
        vertices[0].adjacentes[3] = 69;
        vertices[1].adjacentes[0] = 2;
        vertices[1].adjacentes[1] = -1;
        vertices[1].adjacentes[2] = -1;
        vertices[1].adjacentes[3] = -1;
        vertices[2].adjacentes[0] = -1;
        vertices[2].adjacentes[1] = 69;
        vertices[2].adjacentes[2] = 1;
        vertices[2].adjacentes[3] = 70;
        vertices[3].adjacentes[0] = 71;
        vertices[3].adjacentes[1] = 70;
        vertices[3].adjacentes[2] = -1;
        vertices[3].adjacentes[3] = -1;
        vertices[4].adjacentes[0] = -1;
        vertices[4].adjacentes[1] = 72;
        vertices[4].adjacentes[2] = 71;
        vertices[4].adjacentes[3] = -1;
        vertices[5].adjacentes[0] = -1;
        vertices[5].adjacentes[1] = 8;
        vertices[5].adjacentes[2] = 6;
        vertices[5].adjacentes[3] = 72;
        vertices[6].adjacentes[0] = 5;
        vertices[6].adjacentes[1] = 7;
        vertices[6].adjacentes[2] = -1;
        vertices[6].adjacentes[3] = -1;
        vertices[7].adjacentes[0] = -1;
        vertices[7].adjacentes[1] = -1;
        vertices[7].adjacentes[2] = -1;
        vertices[7].adjacentes[3] = 6;
        vertices[8].adjacentes[0] = 73;
        vertices[8].adjacentes[1] = -1;
        vertices[8].adjacentes[2] = -1;
        vertices[8].adjacentes[3] = 5;
        vertices[9].adjacentes[0] = -1;
        vertices[9].adjacentes[1] = -1;
        vertices[9].adjacentes[2] = 73;
        vertices[9].adjacentes[3] = 74;
        vertices[10].adjacentes[0] = 76;
        vertices[10].adjacentes[1] = 74;
        vertices[10].adjacentes[2] = -1;
        vertices[10].adjacentes[3] = 75;
        vertices[11].adjacentes[0] = -1;
        vertices[11].adjacentes[1] = -1;
        vertices[11].adjacentes[2] = 76;
        vertices[11].adjacentes[3] = 12;
        vertices[12].adjacentes[0] = 94;
        vertices[12].adjacentes[1] = 11;
        vertices[12].adjacentes[2] = -1;
        vertices[12].adjacentes[3] = 28;
        vertices[13].adjacentes[0] = -1;
        vertices[13].adjacentes[1] = 98;
        vertices[13].adjacentes[2] = 94;
        vertices[13].adjacentes[3] = -1;
        vertices[14].adjacentes[0] = 102;
        vertices[14].adjacentes[1] = -1;
        vertices[14].adjacentes[2] = 97;
        vertices[14].adjacentes[3] = 98;
        vertices[15].adjacentes[0] = 97;
        vertices[15].adjacentes[1] = -1;
        vertices[15].adjacentes[2] = -1;
        vertices[15].adjacentes[3] = 16;
        vertices[16].adjacentes[0] = -1;
        vertices[16].adjacentes[1] = 15;
        vertices[16].adjacentes[2] = 93;
        vertices[16].adjacentes[3] = -1;
        vertices[17].adjacentes[0] = 93;
        vertices[17].adjacentes[1] = 18;
        vertices[17].adjacentes[2] = -1;
        vertices[17].adjacentes[3] = -1;
        vertices[18].adjacentes[0] = -1;
        vertices[18].adjacentes[1] = -1;
        vertices[18].adjacentes[2] = -1;
        vertices[18].adjacentes[3] = 17;
        vertices[19].adjacentes[0] = 103;
        vertices[19].adjacentes[1] = 68;
        vertices[19].adjacentes[2] = 102;
        vertices[19].adjacentes[3] = -1;
        vertices[20].adjacentes[0] = -1;
        vertices[20].adjacentes[1] = -1;
        vertices[20].adjacentes[2] = 103;
        vertices[20].adjacentes[3] = 108;
        vertices[21].adjacentes[0] = -1;
        vertices[21].adjacentes[1] = -1;
        vertices[21].adjacentes[2] = 22;
        vertices[21].adjacentes[3] = -1;
        vertices[22].adjacentes[0] = 21;
        vertices[22].adjacentes[1] = 108;
        vertices[22].adjacentes[2] = 107;
        vertices[22].adjacentes[3] = -1;
        vertices[23].adjacentes[0] = 107;
        vertices[23].adjacentes[1] = 106;
        vertices[23].adjacentes[2] = -1;
        vertices[23].adjacentes[3] = -1;
        vertices[24].adjacentes[0] = -1;
        vertices[24].adjacentes[1] = -1;
        vertices[24].adjacentes[2] = 105;
        vertices[24].adjacentes[3] = 106;
        vertices[25].adjacentes[0] = 105;
        vertices[25].adjacentes[1] = -1;
        vertices[25].adjacentes[2] = -1;
        vertices[25].adjacentes[3] = 104;
        vertices[26].adjacentes[0] = -1;
        vertices[26].adjacentes[1] = -1;
        vertices[26].adjacentes[2] = 109;
        vertices[26].adjacentes[3] = 110;
        vertices[27].adjacentes[0] = 109;
        vertices[27].adjacentes[1] = 104;
        vertices[27].adjacentes[2] = 96;
        vertices[27].adjacentes[3] = -1;
        vertices[28].adjacentes[0] = 96;
        vertices[28].adjacentes[1] = 12;
        vertices[28].adjacentes[2] = -1;
        vertices[28].adjacentes[3] = 40;
        vertices[29].adjacentes[0] = -1;
        vertices[29].adjacentes[1] = -1;
        vertices[29].adjacentes[2] = 30;
        vertices[29].adjacentes[3] = -1;
        vertices[30].adjacentes[0] = 29;
        vertices[30].adjacentes[1] = 75;
        vertices[30].adjacentes[2] = 77;
        vertices[30].adjacentes[3] = -1;
        vertices[31].adjacentes[0] = 77;
        vertices[31].adjacentes[1] = -1;
        vertices[31].adjacentes[2] = 32;
        vertices[31].adjacentes[3] = 78;
        vertices[32].adjacentes[0] = 31;
        vertices[32].adjacentes[1] = -1;
        vertices[32].adjacentes[2] = -1;
        vertices[32].adjacentes[3] = -1;
        vertices[33].adjacentes[0] = -1;
        vertices[33].adjacentes[1] = 78;
        vertices[33].adjacentes[2] = 34;
        vertices[33].adjacentes[3] = 81;
        vertices[34].adjacentes[0] = 33;
        vertices[34].adjacentes[1] = -1;
        vertices[34].adjacentes[2] = -1;
        vertices[34].adjacentes[3] = -1;
        vertices[35].adjacentes[0] = 84;
        vertices[35].adjacentes[1] = 81;
        vertices[35].adjacentes[2] = -1;
        vertices[35].adjacentes[3] = -1;
        vertices[36].adjacentes[0] = 86;
        vertices[36].adjacentes[1] = 85;
        vertices[36].adjacentes[2] = 84;
        vertices[36].adjacentes[3] = 53;
        vertices[37].adjacentes[0] = -1;
        vertices[37].adjacentes[1] = -1;
        vertices[37].adjacentes[2] = 38;
        vertices[37].adjacentes[3] = 85;
        vertices[38].adjacentes[0] = 37;
        vertices[38].adjacentes[1] = 79;
        vertices[38].adjacentes[2] = -1;
        vertices[38].adjacentes[3] = -1;
        vertices[39].adjacentes[0] = 80;
        vertices[39].adjacentes[1] = -1;
        vertices[39].adjacentes[2] = -1;
        vertices[39].adjacentes[3] = 79;
        vertices[40].adjacentes[0] = -1;
        vertices[40].adjacentes[1] = 28;
        vertices[40].adjacentes[2] = 80;
        vertices[40].adjacentes[3] = -1;
        vertices[41].adjacentes[0] = 101;
        vertices[41].adjacentes[1] = -1;
        vertices[41].adjacentes[2] = -1;
        vertices[41].adjacentes[3] = 92;
        vertices[42].adjacentes[0] = -1;
        vertices[42].adjacentes[1] = 92;
        vertices[42].adjacentes[2] = 90;
        vertices[42].adjacentes[3] = -1;
        vertices[43].adjacentes[0] = 90;
        vertices[43].adjacentes[1] = -1;
        vertices[43].adjacentes[2] = -1;
        vertices[43].adjacentes[3] = 87;
        vertices[44].adjacentes[0] = -1;
        vertices[44].adjacentes[1] = 87;
        vertices[44].adjacentes[2] = 86;
        vertices[44].adjacentes[3] = -1;
        vertices[45].adjacentes[0] = -1;
        vertices[45].adjacentes[1] = -1;
        vertices[45].adjacentes[2] = 101;
        vertices[45].adjacentes[3] = 46;
        vertices[46].adjacentes[0] = -1;
        vertices[46].adjacentes[1] = 45;
        vertices[46].adjacentes[2] = 100;
        vertices[46].adjacentes[3] = -1;
        vertices[47].adjacentes[0] = 100;
        vertices[47].adjacentes[1] = -1;
        vertices[47].adjacentes[2] = -1;
        vertices[47].adjacentes[3] = 95;
        vertices[48].adjacentes[0] = -1;
        vertices[48].adjacentes[1] = 95;
        vertices[48].adjacentes[2] = 91;
        vertices[48].adjacentes[3] = 58;
        vertices[49].adjacentes[0] = 91;
        vertices[49].adjacentes[1] = -1;
        vertices[49].adjacentes[2] = -1;
        vertices[49].adjacentes[3] = 89;
        vertices[50].adjacentes[0] = 82;
        vertices[50].adjacentes[1] = -1;
        vertices[50].adjacentes[2] = -1;
        vertices[50].adjacentes[3] = -1;
        vertices[51].adjacentes[0] = 83;
        vertices[51].adjacentes[1] = -1;
        vertices[51].adjacentes[2] = 82;
        vertices[51].adjacentes[3] = 52;
        vertices[52].adjacentes[0] = -1;
        vertices[52].adjacentes[1] = 51;
        vertices[52].adjacentes[2] = -1;
        vertices[52].adjacentes[3] = -1;
        vertices[53].adjacentes[0] = -1;
        vertices[53].adjacentes[1] = 36;
        vertices[53].adjacentes[2] = 83;
        vertices[53].adjacentes[3] = -1;
        vertices[54].adjacentes[0] = -1;
        vertices[54].adjacentes[1] = 55;
        vertices[54].adjacentes[2] = -1;
        vertices[54].adjacentes[3] = -1;
        vertices[55].adjacentes[0] = 88;
        vertices[55].adjacentes[1] = -1;
        vertices[55].adjacentes[2] = -1;
        vertices[55].adjacentes[3] = 54;
        vertices[56].adjacentes[0] = -1;
        vertices[56].adjacentes[1] = 89;
        vertices[56].adjacentes[2] = 88;
        vertices[56].adjacentes[3] = 57;
        vertices[57].adjacentes[0] = -1;
        vertices[57].adjacentes[1] = 56;
        vertices[57].adjacentes[2] = -1;
        vertices[57].adjacentes[3] = -1;
        vertices[58].adjacentes[0] = 99;
        vertices[58].adjacentes[1] = 48;
        vertices[58].adjacentes[2] = -1;
        vertices[58].adjacentes[3] = -1;
        vertices[59].adjacentes[0] = -1;
        vertices[59].adjacentes[1] = 112;
        vertices[59].adjacentes[2] = 99;
        vertices[59].adjacentes[3] = -1;
        vertices[60].adjacentes[0] = 113;
        vertices[60].adjacentes[1] = -1;
        vertices[60].adjacentes[2] = -1;
        vertices[60].adjacentes[3] = 112;
        vertices[61].adjacentes[0] = 62;
        vertices[61].adjacentes[1] = -1;
        vertices[61].adjacentes[2] = 113;
        vertices[61].adjacentes[3] = 114;
        vertices[62].adjacentes[0] = -1;
        vertices[62].adjacentes[1] = 111;
        vertices[62].adjacentes[2] = 61;
        vertices[62].adjacentes[3] = -1;
        vertices[63].adjacentes[0] = 64;
        vertices[63].adjacentes[1] = 110;
        vertices[63].adjacentes[2] = -1;
        vertices[63].adjacentes[3] = 111;
        vertices[64].adjacentes[0] = -1;
        vertices[64].adjacentes[1] = -1;
        vertices[64].adjacentes[2] = 63;
        vertices[64].adjacentes[3] = -1;
        vertices[65].adjacentes[0] = 115;
        vertices[65].adjacentes[1] = 114;
        vertices[65].adjacentes[2] = -1;
        vertices[65].adjacentes[3] = 67;
        vertices[66].adjacentes[0] = -1;
        vertices[66].adjacentes[1] = -1;
        vertices[66].adjacentes[2] = 115;
        vertices[66].adjacentes[3] = -1;
        vertices[67].adjacentes[0] = -1;
        vertices[67].adjacentes[1] = 65;
        vertices[67].adjacentes[2] = -1;
        vertices[67].adjacentes[3] = -1;
        vertices[68].adjacentes[0] = -1;
        vertices[68].adjacentes[1] = -1;
        vertices[68].adjacentes[2] = -1;
        vertices[68].adjacentes[3] = 19;
        vertices[69].adjacentes[0] = -1;
        vertices[69].adjacentes[1] = 0;
        vertices[69].adjacentes[2] = -1;
        vertices[69].adjacentes[3] = 2;
        vertices[70].adjacentes[0] = -1;
        vertices[70].adjacentes[1] = 2;
        vertices[70].adjacentes[2] = -1;
        vertices[70].adjacentes[3] = 3;
        vertices[71].adjacentes[0] = 4;
        vertices[71].adjacentes[1] = -1;
        vertices[71].adjacentes[2] = 3;
        vertices[71].adjacentes[3] = -1;
        vertices[72].adjacentes[0] = -1;
        vertices[72].adjacentes[1] = 5;
        vertices[72].adjacentes[2] = -1;
        vertices[72].adjacentes[3] = 4;
        vertices[73].adjacentes[0] = 9;
        vertices[73].adjacentes[1] = -1;
        vertices[73].adjacentes[2] = 8;
        vertices[73].adjacentes[3] = -1;
        vertices[74].adjacentes[0] = -1;
        vertices[74].adjacentes[1] = 9;
        vertices[74].adjacentes[2] = -1;
        vertices[74].adjacentes[3] = 10;
        vertices[75].adjacentes[0] = -1;
        vertices[75].adjacentes[1] = 10;
        vertices[75].adjacentes[2] = -1;
        vertices[75].adjacentes[3] = 30;
        vertices[76].adjacentes[0] = 11;
        vertices[76].adjacentes[1] = -1;
        vertices[76].adjacentes[2] = 10;
        vertices[76].adjacentes[3] = -1;
        vertices[77].adjacentes[0] = 30;
        vertices[77].adjacentes[1] = -1;
        vertices[77].adjacentes[2] = 31;
        vertices[77].adjacentes[3] = -1;
        vertices[78].adjacentes[0] = -1;
        vertices[78].adjacentes[1] = 31;
        vertices[78].adjacentes[2] = -1;
        vertices[78].adjacentes[3] = 33;
        vertices[79].adjacentes[0] = -1;
        vertices[79].adjacentes[1] = 39;
        vertices[79].adjacentes[2] = -1;
        vertices[79].adjacentes[3] = 38;
        vertices[80].adjacentes[0] = 40;
        vertices[80].adjacentes[1] = -1;
        vertices[80].adjacentes[2] = 39;
        vertices[80].adjacentes[3] = -1;
        vertices[81].adjacentes[0] = -1;
        vertices[81].adjacentes[1] = 33;
        vertices[81].adjacentes[2] = -1;
        vertices[81].adjacentes[3] = 35;
        vertices[82].adjacentes[0] = 51;
        vertices[82].adjacentes[1] = -1;
        vertices[82].adjacentes[2] = 50;
        vertices[82].adjacentes[3] = -1;
        vertices[83].adjacentes[0] = 53;
        vertices[83].adjacentes[1] = -1;
        vertices[83].adjacentes[2] = 51;
        vertices[83].adjacentes[3] = -1;
        vertices[84].adjacentes[0] = 36;
        vertices[84].adjacentes[1] = -1;
        vertices[84].adjacentes[2] = 35;
        vertices[84].adjacentes[3] = -1;
        vertices[85].adjacentes[0] = -1;
        vertices[85].adjacentes[1] = 37;
        vertices[85].adjacentes[2] = -1;
        vertices[85].adjacentes[3] = 36;
        vertices[86].adjacentes[0] = 44;
        vertices[86].adjacentes[1] = -1;
        vertices[86].adjacentes[2] = 36;
        vertices[86].adjacentes[3] = -1;
        vertices[87].adjacentes[0] = -1;
        vertices[87].adjacentes[1] = 43;
        vertices[87].adjacentes[2] = -1;
        vertices[87].adjacentes[3] = 44;
        vertices[88].adjacentes[0] = 56;
        vertices[88].adjacentes[1] = -1;
        vertices[88].adjacentes[2] = 55;
        vertices[88].adjacentes[3] = -1;
        vertices[89].adjacentes[0] = -1;
        vertices[89].adjacentes[1] = 49;
        vertices[89].adjacentes[2] = -1;
        vertices[89].adjacentes[3] = 56;
        vertices[90].adjacentes[0] = 48;
        vertices[90].adjacentes[1] = -1;
        vertices[90].adjacentes[2] = 49;
        vertices[90].adjacentes[3] = -1;
        vertices[91].adjacentes[0] = 42;
        vertices[91].adjacentes[1] = -1;
        vertices[91].adjacentes[2] = 43;
        vertices[91].adjacentes[3] = -1;
        vertices[92].adjacentes[0] = -1;
        vertices[92].adjacentes[1] = 41;
        vertices[92].adjacentes[2] = -1;
        vertices[92].adjacentes[3] = 42;
        vertices[93].adjacentes[0] = 16;
        vertices[93].adjacentes[1] = -1;
        vertices[93].adjacentes[2] = 17;
        vertices[93].adjacentes[3] = -1;
        vertices[94].adjacentes[0] = 13;
        vertices[94].adjacentes[1] = -1;
        vertices[94].adjacentes[2] = 12;
        vertices[94].adjacentes[3] = -1;
        vertices[95].adjacentes[0] = -1;
        vertices[95].adjacentes[1] = 47;
        vertices[95].adjacentes[2] = -1;
        vertices[95].adjacentes[3] = 48;
        vertices[96].adjacentes[0] = 27;
        vertices[96].adjacentes[1] = -1;
        vertices[96].adjacentes[2] = 28;
        vertices[96].adjacentes[3] = -1;
        vertices[97].adjacentes[0] = 14;
        vertices[97].adjacentes[1] = -1;
        vertices[97].adjacentes[2] = 15;
        vertices[97].adjacentes[3] = -1;
        vertices[98].adjacentes[0] = -1;
        vertices[98].adjacentes[1] = 14;
        vertices[98].adjacentes[2] = -1;
        vertices[98].adjacentes[3] = 13;
        vertices[99].adjacentes[0] = 59;
        vertices[99].adjacentes[1] = -1;
        vertices[99].adjacentes[2] = 58;
        vertices[99].adjacentes[3] = -1;
        vertices[100].adjacentes[0] = 46;
        vertices[100].adjacentes[1] = -1;
        vertices[100].adjacentes[2] = 47;
        vertices[100].adjacentes[3] = -1;
        vertices[101].adjacentes[0] = 45;
        vertices[101].adjacentes[1] = -1;
        vertices[101].adjacentes[2] = 41;
        vertices[101].adjacentes[3] = -1;
        vertices[102].adjacentes[0] = 19;
        vertices[102].adjacentes[1] = -1;
        vertices[102].adjacentes[2] = 14;
        vertices[102].adjacentes[3] = -1;
        vertices[103].adjacentes[0] = 20;
        vertices[103].adjacentes[1] = -1;
        vertices[103].adjacentes[2] = 19;
        vertices[103].adjacentes[3] = -1;
        vertices[104].adjacentes[0] = -1;
        vertices[104].adjacentes[1] = 25;
        vertices[104].adjacentes[2] = -1;
        vertices[104].adjacentes[3] = 27;
        vertices[105].adjacentes[0] = 24;
        vertices[105].adjacentes[1] = -1;
        vertices[105].adjacentes[2] = 25;
        vertices[105].adjacentes[3] = -1;
        vertices[106].adjacentes[0] = -1;
        vertices[106].adjacentes[1] = 24;
        vertices[106].adjacentes[2] = -1;
        vertices[106].adjacentes[3] = 23;
        vertices[107].adjacentes[0] = 22;
        vertices[107].adjacentes[1] = -1;
        vertices[107].adjacentes[2] = 23;
        vertices[107].adjacentes[3] = -1;
        vertices[108].adjacentes[0] = -1;
        vertices[108].adjacentes[1] = 20;
        vertices[108].adjacentes[2] = -1;
        vertices[108].adjacentes[3] = 22;
        vertices[109].adjacentes[0] = 26;
        vertices[109].adjacentes[1] = -1;
        vertices[109].adjacentes[2] = 27;
        vertices[109].adjacentes[3] = -1;
        vertices[110].adjacentes[0] = -1;
        vertices[110].adjacentes[1] = 26;
        vertices[110].adjacentes[2] = -1;
        vertices[110].adjacentes[3] = 63;
        vertices[111].adjacentes[0] = -1;
        vertices[111].adjacentes[1] = 63;
        vertices[111].adjacentes[2] = -1;
        vertices[111].adjacentes[3] = 62;
        vertices[112].adjacentes[0] = -1;
        vertices[112].adjacentes[1] = 60;
        vertices[112].adjacentes[2] = -1;
        vertices[112].adjacentes[3] = 59;
        vertices[113].adjacentes[0] = 61;
        vertices[113].adjacentes[1] = -1;
        vertices[113].adjacentes[2] = 60;
        vertices[113].adjacentes[3] = -1;
        vertices[114].adjacentes[0] = -1;
        vertices[114].adjacentes[1] = 61;
        vertices[114].adjacentes[2] = -1;
        vertices[114].adjacentes[3] = 65;
        vertices[115].adjacentes[0] = 66;
        vertices[115].adjacentes[1] = -1;
        vertices[115].adjacentes[2] = 65;
        vertices[115].adjacentes[3] = -1;

        vertices[0].x = -26.703;
        vertices[0].y = -19.025;
        vertices[1].x = -29.3095;
        vertices[1].y = -14.1248;
        vertices[2].x = -26.4597;
        vertices[2].y = -14.1596;
        vertices[3].x = -26.5292;
        vertices[3].y = -9.39844;
        vertices[4].x = -19.4744;
        vertices[4].y = -9.36368;
        vertices[5].x = -19.3701;
        vertices[5].y = -16.0362;
        vertices[6].x = -22.9844;
        vertices[6].y = -16.2448;
        vertices[7].x = -23.0192;
        vertices[7].y = -19.164;
        vertices[8].x = -19.3354;
        vertices[8].y = -17.7739;
        vertices[9].x = -13.8097;
        vertices[9].y = -17.7739;
        vertices[10].x = -13.9834;
        vertices[10].y = -12.4914;
        vertices[11].x = -5.81649;
        vertices[11].y = -12.3177;
        vertices[12].x = -5.71223;
        vertices[12].y = -8.35585;
        vertices[13].x = 6.76408;
        vertices[13].y = -8.56436;
        vertices[14].x = 6.76408;
        vertices[14].y = -17.7739;
        vertices[15].x = 1.79441;
        vertices[15].y = -17.8086;
        vertices[16].x = 1.75966;
        vertices[16].y = -16.21;
        vertices[17].x = -9.22227;
        vertices[17].y = -16.1405;
        vertices[18].x = -9.25703;
        vertices[18].y = -19.1988;
        vertices[19].x = 14.6877;
        vertices[19].y = -17.5306;
        vertices[20].x = 25.7044;
        vertices[20].y = -17.6349;
        vertices[21].x = 29.4577;
        vertices[21].y = -7.93881;
        vertices[22].x = 25.9129;
        vertices[22].y = -8.04307;
        vertices[23].x = 20.8043;
        vertices[23].y = -8.14733;
        vertices[24].x = 20.7348;
        vertices[24].y = -12.7;
        vertices[25].x = 15.5218;
        vertices[25].y = -12.9085;
        vertices[26].x = 25.5654;
        vertices[26].y = -4.35926;
        vertices[27].x = 15.5913;
        vertices[27].y = -4.18549;
        vertices[28].x = -5.81649;
        vertices[28].y = -4.15074;
        vertices[29].x = -9.5003;
        vertices[29].y = -5.36709;
        vertices[30].x = -13.7402;
        vertices[30].y = -5.33234;
        vertices[31].x = -25.2781;
        vertices[31].y = -5.4366;
        vertices[32].x = -29.1705;
        vertices[32].y = -5.4366;
        vertices[33].x = -25.4519;
        vertices[33].y = 7.73476;
        vertices[34].x = -29.518;
        vertices[34].y = 7.73476;
        vertices[35].x = -25.3476;
        vertices[35].y = 13.7818;
        vertices[36].x = -17.6325;
        vertices[36].y = 13.9208;
        vertices[37].x = -17.5977;
        vertices[37].y = 5.68434;
        vertices[38].x = -21.5596;
        vertices[38].y = 5.44107;
        vertices[39].x = -21.5248;
        vertices[39].y = -1.12724;
        vertices[40].x = -5.9555;
        vertices[40].y = -1.44001;
        vertices[41].x = -1.57663;
        vertices[41].y = 0.784176;
        vertices[42].x = -1.57663;
        vertices[42].y = 5.61483;
        vertices[43].x = -10.8117;
        vertices[43].y = 5.89468;
        vertices[44].x = -10.8676;
        vertices[44].y = 14.0103;
        vertices[45].x = 19.1882;
        vertices[45].y = 0.521568;
        vertices[46].x = 19.1882;
        vertices[46].y = 3.99171;
        vertices[47].x = 4.24425;
        vertices[47].y = 4.3835;
        vertices[48].x = 4.18828;
        vertices[48].y = 11.1559;
        vertices[49].x = -5.04676;
        vertices[49].y = 11.2678;
        vertices[50].x = -28.9459;
        vertices[50].y = 17.5364;
        vertices[51].x = -23.0131;
        vertices[51].y = 17.3685;
        vertices[52].x = -23.0131;
        vertices[52].y = 19.0476;
        vertices[53].x = -17.4161;
        vertices[53].y = 17.7603;
        vertices[54].x = -13.89;
        vertices[54].y = 19.3834;
        vertices[55].x = -13.9321;
        vertices[55].y = 17.3229;
        vertices[56].x = -5.3957;
        vertices[56].y = 17.407;
        vertices[57].x = -5.01724;
        vertices[57].y = 19.5096;
        vertices[58].x = 3.77143;
        vertices[58].y = 15.5989;
        vertices[59].x = 15.0411;
        vertices[59].y = 15.5989;
        vertices[60].x = 14.8729;
        vertices[60].y = 9.37529;
        vertices[61].x = 21.6011;
        vertices[61].y = 9.50145;
        vertices[62].x = 25.3857;
        vertices[62].y = 9.75375;
        vertices[63].x = 25.3857;
        vertices[63].y = 1.30149;
        vertices[64].x = 29.2544;
        vertices[64].y = 1.42764;
        vertices[65].x = 21.6011;
        vertices[65].y = 15.3465;
        vertices[66].x = 29.4646;
        vertices[66].y = 15.4727;
        vertices[67].x = 21.7272;
        vertices[67].y = 19.4255;
        vertices[68].x = 14.8309;
        vertices[68].y = -19.3456;
        vertices[69].x = -26.5474;
        vertices[69].y = -17.4112;
        vertices[70].x = -26.5474;
        vertices[70].y = -11.3559;
        vertices[71].x = -23.0992;
        vertices[71].y = -9.46358;
        vertices[72].x = -19.3987;
        vertices[72].y = -12.6174;
        vertices[73].x = -16.7915;
        vertices[73].y = -17.7897;
        vertices[74].x = -13.8059;
        vertices[74].y = -14.9723;
        vertices[75].x = -13.848;
        vertices[75].y = -9.08512;
        vertices[76].x = -10.0634;
        vertices[76].y = -12.4913;
        vertices[77].x = -19.5669;
        vertices[77].y = -5.25847;
        vertices[78].x = -25.2018;
        vertices[78].y = 1.38559;
        vertices[79].x = -21.5854;
        vertices[79].y = 1.93226;
        vertices[80].x = -14.1003;
        vertices[80].y = -1.17952;
        vertices[81].x = -25.37;
        vertices[81].y = 10.9312;
        vertices[82].x = -27.0099;
        vertices[82].y = 17.4911;
        vertices[83].x = -19.8192;
        vertices[83].y = 17.5752;
        vertices[84].x = -21.291;
        vertices[84].y = 13.9168;
        vertices[85].x = -17.5905;
        vertices[85].y = 10.0061;
        vertices[86].x = -14.7731;
        vertices[86].y = 14.0009;
        vertices[87].x = -10.7782;
        vertices[87].y = 10.5527;
        vertices[88].x = -9.60081;
        vertices[88].y = 17.5332;
        vertices[89].x = -5.10135;
        vertices[89].y = 14.8419;
        vertices[90].x = -0.90;
        vertices[90].y = 11.4358;
        vertices[91].x = -1.52701;
        vertices[91].y = 11.4358;
        vertices[92].x = -6.56906;
        vertices[92].y = 5.41725;
        vertices[93].x = -3.9198;
        vertices[93].y = -16.2043;
        vertices[94].x = 0.78168;
        vertices[94].y = -8.53644;
        vertices[95].x = 4.30779;
        vertices[95].y = 7.86276;
        vertices[96].x = 5.37122;
        vertices[96].y = -4.28272;
        vertices[97].x = 4.13988;
        vertices[97].y = -17.9954;
        vertices[98].x = 6.93838;
        vertices[98].y = -12.7342;
        vertices[99].x = 9.40105;
        vertices[99].y = 15.3627;
        vertices[100].x = 11.6399;
        vertices[100].y = 4.28068;
        vertices[101].x = 8.16971;
        vertices[101].y = 0.474724;
        vertices[102].x = 10.5205;
        vertices[102].y = -17.8275;
        vertices[103].x = 20.595;
        vertices[103].y = -17.7155;
        vertices[104].x = 15.6137;
        vertices[104].y = -9.09614;
        vertices[105].x = 18.0764;
        vertices[105].y = -12.9021;
        vertices[106].x = 20.651;
        vertices[106].y = -10.4394;
        vertices[107].x = 23.1137;
        vertices[107].y = -8.03271;
        vertices[108].x = 25.8003;
        vertices[108].y = -12.6222;
        vertices[109].x = 21.0988;
        vertices[109].y = -4.28272;
        vertices[110].x = 25.5764;
        vertices[110].y = -1.42825;
        vertices[111].x = 25.6883;
        vertices[111].y = 6.35157;
        vertices[112].x = 14.8301;
        vertices[112].y = 12.6202;
        vertices[113].x = 18.1883;
        vertices[113].y = 9.31798;
        vertices[114].x = 21.7704;
        vertices[114].y = 12.4523;
        vertices[115].x = 26.6398;
        vertices[115].y = 15.4187;
//	vertices[116].x = -17.4161;  vertices[115].y = 15.4187;
    }
}
