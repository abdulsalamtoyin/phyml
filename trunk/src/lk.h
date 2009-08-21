/*

PHYML :  a program that  computes maximum likelihood  phylogenies from
DNA or AA homologous sequences 

Copyright (C) Stephane Guindon. Oct 2003 onward

All parts of  the source except where indicated  are distributed under
the GNU public licence.  See http://www.opensource.org for details.

*/

#ifndef ML_H
#define ML_H

#include "utilities.h"
#include "optimiz.h"
#include "models.h"
#include "free.h"


void Init_Tips_At_One_Site_Nucleotides_Float(char state, int pos, plkflt *p_lk);
void Init_Tips_At_One_Site_AA_Float(char aa, int pos, plkflt *p_lk);
void Get_All_Partial_Lk(t_tree *tree,t_edge *b_fcus,t_node *a,t_node *d);
void Get_All_Partial_Lk_Scale(t_tree *tree,t_edge *b_fcus,t_node *a,t_node *d);
void Post_Order_Lk(t_node *pere, t_node *fils, t_tree *tree);
void Pre_Order_Lk(t_node *pere, t_node *fils, t_tree *tree);
phydbl Lk(t_tree *tree);
void Site_Lk(t_tree *tree);
phydbl Lk_At_Given_Edge(t_edge *b_fcus,t_tree *tree);
phydbl Return_Abs_Lk(t_tree *tree);
matrix *ML_Dist(calign *data, model *mod);
phydbl Lk_Given_Two_Seq(calign *data, int numseq1, int numseq2, phydbl dist, model *mod, phydbl *loglk);
void Unconstraint_Lk(t_tree *tree);
void Update_P_Lk(t_tree *tree,t_edge *b_fcus,t_node *n);
void Make_Tree_4_Lk(t_tree *tree,calign *cdata,int n_site);
void Init_P_Lk_Tips_Double(t_tree *tree);
void Init_P_Lk_Tips_Int(t_tree *tree);
void Init_P_Lk_At_One_Node(t_node *a, t_tree *tree);
void Update_PMat_At_Given_Edge(t_edge *b_fcus, t_tree *tree);
void Sort_Sites_Based_On_Lk(t_tree *tree);
void Get_Partial_Lk_Scale(t_tree *tree, t_edge *b_fcus, t_node *a, t_node *d);
void Get_Partial_Lk(t_tree *tree, t_edge *b_fcus, t_node *a, t_node *d);
void Init_Tips_At_One_Site_Nucleotides_Int(char state, int pos, short int *p_pars);
void Init_Tips_At_One_Site_AA_Int(char aa, int pos, short int *p_pars);
void Update_P_Lk_Along_A_Path(t_node **path, int path_length, t_tree *tree);
phydbl Lk_Dist(phydbl *F, phydbl dist, model *mod);
phydbl Update_Lk_At_Given_Edge(t_edge *b_fcus, t_tree *tree);
void Update_P_Lk_Greedy(t_tree *tree, t_edge *b_fcus, t_node *n);
void Get_All_Partial_Lk_Scale_Greedy(t_tree *tree, t_edge *b_fcus, t_node *a, t_node *d);
phydbl Lk_Core(t_edge *b, t_tree *tree);
phydbl Lk_Triplet(t_node *a, t_node *d, t_tree *tree);
void Print_Lk_Given_Edge_Recurr(t_node *a, t_node *d, t_edge *b, t_tree *tree);
phydbl *Post_Prob_Rates_At_Given_Edge(t_edge *b, phydbl *post_prob, t_tree *tree);
phydbl Lk_With_MAP_Branch_Rates(t_tree *tree);
void Init_Tips_At_One_Site_Generic_Int(char *state, int ns, int state_len, int pos, short int *p_pars);
void Init_Tips_At_One_Site_Generic_Float(char *state, int ns, int state_len, int pos, plkflt *p_lk);



#endif





