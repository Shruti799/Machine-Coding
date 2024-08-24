#include<bits/stdc++.h>
using namespace std;


class Pawn{
    public:
        bool valid(string& start, string& end, bool& turn, vector<vector<string>>& mat){
            int row1 = start[1]-'0' - 1, row2 = end[1]-'0' - 1;
            int col1 = (int)start[0] - 97, col2 = (int)end[0] - 97;

            if(!turn){
                if(row2<=row1 || row2-row1>2 || abs(col1-col2)>1) return false;
                if(row2-row1==2 && row1!=1) return false;
                if(abs(col1-col2)==1 && mat[row2][col2]=="--") return false;
                if(row2==row1+1 && col2==col1 && mat[row2][col2]!="--") return false;

                mat[row2][col2] = "WP";
                mat[row1][col1] = "--";

                return true;
            }
            else{
                if(row2>=row1 || row1-row2>2 || abs(col1-col2)>1) return false;
                if(row1-row2==2 && row1!=6) return false;
                if(abs(col1-col2)==1 && mat[row2][col2]=="--") return false;
                if(row2==row1-1 && col2==col1 && mat[row2][col2]!="--") return false;

                mat[row2][col2] = "BP";
                mat[row1][col1] = "--";
            }
            return true;
        }
};

class Rook{
    public:
        bool valid(string& start, string& end, bool& turn, vector<vector<string>>& mat){

            int row1 = start[1]-'0' - 1, row2 = end[1]-'0' - 1;
            int col1 = (int)start[0] - 97, col2 = (int)end[0] - 97;

            int i = row1+1, j;

            while(i<8){
                if(mat[i][col1]!="--" && (i!=row2 || col1!=col2)) return false;
                i++;
            }

            i = row1-1;

            while(i>=0){
                if(mat[i][col1]!="--" && (i!=row2 || col1!=col2)) return false;
                i--;
            }

            j = col1+1;

            while(j<8){
                if(mat[row1][j]!="--" && (row1!=row2 || j!=col2)) return false;
                j++;
            }

            j = col1-1;

            while(j>=0){
                if(mat[row1][j]!="--" && (row1!=row2 || j!=col2)) return false;
                j--;
            }

            if(!turn) mat[row2][col2] = "WR";
            else mat[row2][col2] = "BR";

            mat[row1][col1] = "--";

            return true;
        }
};

class Knight{
    public:
        bool valid(string& start, string& end, bool& turn, vector<vector<string>>& mat){

            int row1 = start[1]-'0' - 1, row2 = end[1]-'0' - 1;
            int col1 = (int)start[0] - 97, col2 = (int)end[0] - 97;

            if((abs(row2 - row1) == 2 && abs(col2 - col1) == 1) || (abs(row2 - row1) == 1 && abs(col2 - col1) == 2)){
                if(mat[row2][col2] == "--" || mat[row2][col2][0] != (turn ? 'B' : 'W')){
                    mat[row2][col2] = (turn ? "BN" : "WN");
                    mat[row1][col1] = "--";
                    return true;
                }
            }
            return false;
        }
};

class Bishop{
    public:
        bool valid(string& start, string& end, bool& turn, vector<vector<string>>& mat){

            int row1 = start[1]-'0' - 1, row2 = end[1]-'0' - 1;
            int col1 = (int)start[0] - 97, col2 = (int)end[0] - 97;

            if(abs(row2 - row1) == abs(col2 - col1)){
                int rowDir = (row2 - row1 > 0) ? 1 : -1;
                int colDir = (col2 - col1 > 0) ? 1 : -1;

                int r = row1 + rowDir, c = col1 + colDir;
                while(r != row2 && c != col2){
                    if(mat[r][c] != "--") return false;
                    r += rowDir;
                    c += colDir;
                }

                if(mat[row2][col2] == "--" || mat[row2][col2][0] != (turn ? 'B' : 'W')){
                    mat[row2][col2] = (turn ? "BB" : "WB");
                    mat[row1][col1] = "--";
                    return true;
                }
            }
            return false;
        }
};


class King{
    public:
        bool valid(string& start, string& end, bool& turn, vector<vector<string>>& mat){

            int row1 = start[1]-'0' - 1, row2 = end[1]-'0' - 1;
            int col1 = (int)start[0] - 97, col2 = (int)end[0] - 97;


            if(abs(row2 - row1) <= 1 && abs(col2 - col1) <= 1){
                if(mat[row2][col2] == "--" || mat[row2][col2][0] != (turn ? 'B' : 'W')){
                    mat[row2][col2] = (turn ? "BK" : "WK");
                    mat[row1][col1] = "--";
                    return true;
                }
            }
            return false;
        }
};


class Queen{
    public:
        bool valid(string& start, string& end, bool& turn, vector<vector<string>>& mat){

            int row1 = start[1]-'0' - 1, row2 = end[1]-'0' - 1;
            int col1 = (int)start[0] - 97, col2 = (int)end[0] - 97;

    
            if(row1 == row2 || col1 == col2 || abs(row2 - row1) == abs(col2 - col1)){
                int rowDir = (row2 > row1) ? 1 : (row2 < row1) ? -1 : 0;
                int colDir = (col2 > col1) ? 1 : (col2 < col1) ? -1 : 0;

                int r = row1 + rowDir, c = col1 + colDir;
                while(r != row2 || c != col2){
                    if(mat[r][c] != "--") return false;
                    r += rowDir;
                    c += colDir;
                }

                if(mat[row2][col2] == "--" || mat[row2][col2][0] != (turn ? 'B' : 'W')){
                    mat[row2][col2] = (turn ? "BQ" : "WQ");
                    mat[row1][col1] = "--";
                    return true;
                }
            }
            return false;
        }
};



class Board{
    public:
        vector<vector<string>> mat;
        
        Board(){
            mat = vector<vector<string>>(8,vector<string>(8,"--"));
            mat[0][0] = "WR", mat[0][1] = "WN";
            mat[0][2] = "WB", mat[0][3] = "WQ";
            mat[0][4] = "WK", mat[0][5] = "WB";
            mat[0][6] = "WN", mat[0][7] = "WR";

            for(int i=0;i<8;i++) mat[1][i] = "WP";
            for(int i=0;i<8;i++) mat[6][i] = "BP";

            mat[7][0] = "BR", mat[7][1] = "BN";
            mat[7][2] = "BB", mat[7][3] = "BQ";
            mat[7][4] = "BK", mat[7][5] = "BB";
            mat[7][6] = "BN", mat[7][7] = "BR";
        }

        void printBoard(){
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    cout<<mat[i][j]<<" ";
                }
                cout<<endl;
            }
        }

        bool valid(string& start, string& end, bool& turn){

            Pawn pawn;
            Rook rook;
            Knight knight;
            Bishop bishop;
            King king;
            Queen queen;

            if(pawn.valid(start,end,turn,mat)) return true;
            else if(rook.valid(start,end,turn,mat)) return true;
            else if(knight.valid(start,end,turn,mat)) return true;
            else if(bishop.valid(start,end,turn,mat)) return true;
            else if(king.valid(start,end,turn,mat)) return true;
            else if(queen.valid(start,end,turn,mat)) return true;
            else return false;
        }
};

class Game{
    public:
        Board board;
        bool turn = false;

        Game(){
            if(!turn){
                board.printBoard();
            }
        }

        void play(){

            while(true){
               string start_pos, end_pos;
               cin>>start_pos;
   
               if(start_pos=="exit") break;

               else cin>>end_pos;

               if(!board.valid(start_pos,end_pos,turn)){
                cout<<"Invalid Move"<<endl;
                continue;
               }

               board.printBoard();
               turn = true;
            }
        }
};


int main(){

    Game game;
    game.play();

    return 0;
}