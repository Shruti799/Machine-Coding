#include<bits/stdc++.h>
using namespace std;


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

        bool valid(string& s, string& e, bool& turn){
            if(!Pawnn.valid(s,e,turn,mat) && !Rook.valid(s,e,turn,mat) && !Knight.valid(s,e,turn,mat) && !Bishop.valid(s,e,turn,mat) && !King.valid(s,e,turn,mat) && !Queen.valid(s,e,turn,mat)){
                return false;
            }
            else return true;
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

               if(!board.valid(start_pos,end_pos,turn)){
                cout<<"Invalid Move"<<endl;
               }

            }
            board.printBoard();
            turn = true;

        }
};

class Pawnn{
    public:
        bool valid(string& start, string& end, bool& turn, vector<vector<string>>& mat){
            int row1 = start[1], row2 = end[1];
            int col1 = 97 - (int)start[0], col2 = 97 - (int)end[0];

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


int main(){

    Game game;
    return 0;
}