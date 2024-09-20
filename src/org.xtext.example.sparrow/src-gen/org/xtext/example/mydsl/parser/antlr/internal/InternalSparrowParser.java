package org.xtext.example.mydsl.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.xtext.example.mydsl.services.SparrowGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalSparrowParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_DECIMAL", "RULE_URL_STRING", "RULE_MATH_SYMBOL", "RULE_ARITHMETIC_OPERATOR", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'Contract'", "'extends'", "'{'", "'}'", "'Require'", "':'", "','", "';'", "'isTime'", "'isTrue'", "'logic'", "'check'", "'isCompleted'", "'isDone'", "'isRequest'", "'compareString'", "'timeSub'", "'SetDate'", "'transfer'", "'changeState'", "'Init'", "'='", "'('", "')'", "'Group'", "'RA'", "'AA'", "'CA'", "'PA'", "'ContractMessage'", "'string'", "'uint'", "'address'", "'int'", "'bytes'", "'bytes32'", "'bool'", "'fixed'", "'ufixed'", "'date'", "'duration'", "'years'", "'months'", "'days'", "'hours'", "'mins'", "'now'", "'a'", "'/'", "'Token'", "'Conditions'", "'['", "']'", "'and'", "'or'", "'Operations'", "'Rules'", "'Exclusive'", "'Parallel'", "'Additional'", "'If:'", "'!'", "'G'", "'Then'", "'Else'", "'Repeat'", "'SetDate('", "'SubRule'", "'FailResult:'", "'within'", "'after'", "'before'", "'compareString('", "'timeSub('", "'r'", "'isTime('", "'logic('", "'isTrue('", "'isDone('", "'check('", "'getRuleTime('", "'\"'", "'f'", "'p'", "'s'", "'.'", "'o'", "'SetMessage('", "'new'", "'transfer('", "'assignString('", "'assign('", "'ContractState'", "'start'", "'pause'", "'restart'", "'terminate'", "'finish'", "'change('", "'CM'", "'true'", "'false'"
    };
    public static final int T__50=50;
    public static final int RULE_MATH_SYMBOL=9;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=4;
    public static final int RULE_INT=5;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=11;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__64=64;
    public static final int T__65=65;
    public static final int RULE_ARITHMETIC_OPERATOR=10;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__99=99;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int RULE_DECIMAL=7;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int RULE_URL_STRING=8;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=6;
    public static final int RULE_SL_COMMENT=12;
    public static final int T__77=77;
    public static final int T__78=78;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int T__115=115;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__114=114;
    public static final int T__75=75;
    public static final int T__117=117;
    public static final int T__76=76;
    public static final int T__116=116;
    public static final int T__80=80;
    public static final int T__111=111;
    public static final int T__81=81;
    public static final int T__110=110;
    public static final int T__82=82;
    public static final int T__113=113;
    public static final int T__83=83;
    public static final int T__112=112;
    public static final int RULE_WS=13;
    public static final int RULE_ANY_OTHER=14;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int T__109=109;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int T__86=86;
    public static final int T__106=106;
    public static final int T__87=87;
    public static final int T__105=105;

    // delegates
    // delegators


        public InternalSparrowParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalSparrowParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalSparrowParser.tokenNames; }
    public String getGrammarFileName() { return "InternalSparrow.g"; }



     	private SparrowGrammarAccess grammarAccess;

        public InternalSparrowParser(TokenStream input, SparrowGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected SparrowGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalSparrow.g:64:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalSparrow.g:64:46: (iv_ruleModel= ruleModel EOF )
            // InternalSparrow.g:65:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalSparrow.g:71:1: ruleModel returns [EObject current=null] : ( (otherlv_0= 'import' ( (lv_packageName_1_0= RULE_ID ) ) )* otherlv_2= 'Contract' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'extends' ( (lv_extendName_5_0= RULE_ID ) ) )? otherlv_6= '{' ( (lv_subjects_7_0= ruleSubject ) )* ( (lv_objects_8_0= ruleObject ) )* ( (lv_group_9_0= ruleGroup ) )* ( (lv_initialize_10_0= ruleInitialize ) )? ( (lv_contractMessage_11_0= ruleContractMessage ) )? ( (lv_Conditions_12_0= ruleCondition ) )? ( (lv_operations_13_0= ruleOperation ) )? ( (lv_ruleStructures_14_0= ruleRuleStructure ) )? ( (lv_require_15_0= ruleRequire ) )? otherlv_16= '}' )? ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_packageName_1_0=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token lv_extendName_5_0=null;
        Token otherlv_6=null;
        Token otherlv_16=null;
        EObject lv_subjects_7_0 = null;

        EObject lv_objects_8_0 = null;

        EObject lv_group_9_0 = null;

        EObject lv_initialize_10_0 = null;

        EObject lv_contractMessage_11_0 = null;

        EObject lv_Conditions_12_0 = null;

        EObject lv_operations_13_0 = null;

        EObject lv_ruleStructures_14_0 = null;

        EObject lv_require_15_0 = null;



        	enterRule();

        try {
            // InternalSparrow.g:77:2: ( ( (otherlv_0= 'import' ( (lv_packageName_1_0= RULE_ID ) ) )* otherlv_2= 'Contract' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'extends' ( (lv_extendName_5_0= RULE_ID ) ) )? otherlv_6= '{' ( (lv_subjects_7_0= ruleSubject ) )* ( (lv_objects_8_0= ruleObject ) )* ( (lv_group_9_0= ruleGroup ) )* ( (lv_initialize_10_0= ruleInitialize ) )? ( (lv_contractMessage_11_0= ruleContractMessage ) )? ( (lv_Conditions_12_0= ruleCondition ) )? ( (lv_operations_13_0= ruleOperation ) )? ( (lv_ruleStructures_14_0= ruleRuleStructure ) )? ( (lv_require_15_0= ruleRequire ) )? otherlv_16= '}' )? )
            // InternalSparrow.g:78:2: ( (otherlv_0= 'import' ( (lv_packageName_1_0= RULE_ID ) ) )* otherlv_2= 'Contract' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'extends' ( (lv_extendName_5_0= RULE_ID ) ) )? otherlv_6= '{' ( (lv_subjects_7_0= ruleSubject ) )* ( (lv_objects_8_0= ruleObject ) )* ( (lv_group_9_0= ruleGroup ) )* ( (lv_initialize_10_0= ruleInitialize ) )? ( (lv_contractMessage_11_0= ruleContractMessage ) )? ( (lv_Conditions_12_0= ruleCondition ) )? ( (lv_operations_13_0= ruleOperation ) )? ( (lv_ruleStructures_14_0= ruleRuleStructure ) )? ( (lv_require_15_0= ruleRequire ) )? otherlv_16= '}' )?
            {
            // InternalSparrow.g:78:2: ( (otherlv_0= 'import' ( (lv_packageName_1_0= RULE_ID ) ) )* otherlv_2= 'Contract' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'extends' ( (lv_extendName_5_0= RULE_ID ) ) )? otherlv_6= '{' ( (lv_subjects_7_0= ruleSubject ) )* ( (lv_objects_8_0= ruleObject ) )* ( (lv_group_9_0= ruleGroup ) )* ( (lv_initialize_10_0= ruleInitialize ) )? ( (lv_contractMessage_11_0= ruleContractMessage ) )? ( (lv_Conditions_12_0= ruleCondition ) )? ( (lv_operations_13_0= ruleOperation ) )? ( (lv_ruleStructures_14_0= ruleRuleStructure ) )? ( (lv_require_15_0= ruleRequire ) )? otherlv_16= '}' )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( ((LA12_0>=15 && LA12_0<=16)) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalSparrow.g:79:3: (otherlv_0= 'import' ( (lv_packageName_1_0= RULE_ID ) ) )* otherlv_2= 'Contract' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= 'extends' ( (lv_extendName_5_0= RULE_ID ) ) )? otherlv_6= '{' ( (lv_subjects_7_0= ruleSubject ) )* ( (lv_objects_8_0= ruleObject ) )* ( (lv_group_9_0= ruleGroup ) )* ( (lv_initialize_10_0= ruleInitialize ) )? ( (lv_contractMessage_11_0= ruleContractMessage ) )? ( (lv_Conditions_12_0= ruleCondition ) )? ( (lv_operations_13_0= ruleOperation ) )? ( (lv_ruleStructures_14_0= ruleRuleStructure ) )? ( (lv_require_15_0= ruleRequire ) )? otherlv_16= '}'
                    {
                    // InternalSparrow.g:79:3: (otherlv_0= 'import' ( (lv_packageName_1_0= RULE_ID ) ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==15) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // InternalSparrow.g:80:4: otherlv_0= 'import' ( (lv_packageName_1_0= RULE_ID ) )
                    	    {
                    	    otherlv_0=(Token)match(input,15,FOLLOW_3); 

                    	    				newLeafNode(otherlv_0, grammarAccess.getModelAccess().getImportKeyword_0_0());
                    	    			
                    	    // InternalSparrow.g:84:4: ( (lv_packageName_1_0= RULE_ID ) )
                    	    // InternalSparrow.g:85:5: (lv_packageName_1_0= RULE_ID )
                    	    {
                    	    // InternalSparrow.g:85:5: (lv_packageName_1_0= RULE_ID )
                    	    // InternalSparrow.g:86:6: lv_packageName_1_0= RULE_ID
                    	    {
                    	    lv_packageName_1_0=(Token)match(input,RULE_ID,FOLLOW_4); 

                    	    						newLeafNode(lv_packageName_1_0, grammarAccess.getModelAccess().getPackageNameIDTerminalRuleCall_0_1_0());
                    	    					

                    	    						if (current==null) {
                    	    							current = createModelElement(grammarAccess.getModelRule());
                    	    						}
                    	    						addWithLastConsumed(
                    	    							current,
                    	    							"packageName",
                    	    							lv_packageName_1_0,
                    	    							"org.eclipse.xtext.common.Terminals.ID");
                    	    					

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);

                    otherlv_2=(Token)match(input,16,FOLLOW_3); 

                    			newLeafNode(otherlv_2, grammarAccess.getModelAccess().getContractKeyword_1());
                    		
                    // InternalSparrow.g:107:3: ( (lv_name_3_0= RULE_ID ) )
                    // InternalSparrow.g:108:4: (lv_name_3_0= RULE_ID )
                    {
                    // InternalSparrow.g:108:4: (lv_name_3_0= RULE_ID )
                    // InternalSparrow.g:109:5: lv_name_3_0= RULE_ID
                    {
                    lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_5); 

                    					newLeafNode(lv_name_3_0, grammarAccess.getModelAccess().getNameIDTerminalRuleCall_2_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getModelRule());
                    					}
                    					setWithLastConsumed(
                    						current,
                    						"name",
                    						lv_name_3_0,
                    						"org.eclipse.xtext.common.Terminals.ID");
                    				

                    }


                    }

                    // InternalSparrow.g:125:3: (otherlv_4= 'extends' ( (lv_extendName_5_0= RULE_ID ) ) )?
                    int alt2=2;
                    int LA2_0 = input.LA(1);

                    if ( (LA2_0==17) ) {
                        alt2=1;
                    }
                    switch (alt2) {
                        case 1 :
                            // InternalSparrow.g:126:4: otherlv_4= 'extends' ( (lv_extendName_5_0= RULE_ID ) )
                            {
                            otherlv_4=(Token)match(input,17,FOLLOW_3); 

                            				newLeafNode(otherlv_4, grammarAccess.getModelAccess().getExtendsKeyword_3_0());
                            			
                            // InternalSparrow.g:130:4: ( (lv_extendName_5_0= RULE_ID ) )
                            // InternalSparrow.g:131:5: (lv_extendName_5_0= RULE_ID )
                            {
                            // InternalSparrow.g:131:5: (lv_extendName_5_0= RULE_ID )
                            // InternalSparrow.g:132:6: lv_extendName_5_0= RULE_ID
                            {
                            lv_extendName_5_0=(Token)match(input,RULE_ID,FOLLOW_6); 

                            						newLeafNode(lv_extendName_5_0, grammarAccess.getModelAccess().getExtendNameIDTerminalRuleCall_3_1_0());
                            					

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getModelRule());
                            						}
                            						setWithLastConsumed(
                            							current,
                            							"extendName",
                            							lv_extendName_5_0,
                            							"org.eclipse.xtext.common.Terminals.ID");
                            					

                            }


                            }


                            }
                            break;

                    }

                    otherlv_6=(Token)match(input,18,FOLLOW_7); 

                    			newLeafNode(otherlv_6, grammarAccess.getModelAccess().getLeftCurlyBracketKeyword_4());
                    		
                    // InternalSparrow.g:153:3: ( (lv_subjects_7_0= ruleSubject ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( ((LA3_0>=41 && LA3_0<=44)) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // InternalSparrow.g:154:4: (lv_subjects_7_0= ruleSubject )
                    	    {
                    	    // InternalSparrow.g:154:4: (lv_subjects_7_0= ruleSubject )
                    	    // InternalSparrow.g:155:5: lv_subjects_7_0= ruleSubject
                    	    {

                    	    					newCompositeNode(grammarAccess.getModelAccess().getSubjectsSubjectParserRuleCall_5_0());
                    	    				
                    	    pushFollow(FOLLOW_7);
                    	    lv_subjects_7_0=ruleSubject();

                    	    state._fsp--;


                    	    					if (current==null) {
                    	    						current = createModelElementForParent(grammarAccess.getModelRule());
                    	    					}
                    	    					add(
                    	    						current,
                    	    						"subjects",
                    	    						lv_subjects_7_0,
                    	    						"org.xtext.example.mydsl.Sparrow.Subject");
                    	    					afterParserOrEnumRuleCall();
                    	    				

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);

                    // InternalSparrow.g:172:3: ( (lv_objects_8_0= ruleObject ) )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==65) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalSparrow.g:173:4: (lv_objects_8_0= ruleObject )
                    	    {
                    	    // InternalSparrow.g:173:4: (lv_objects_8_0= ruleObject )
                    	    // InternalSparrow.g:174:5: lv_objects_8_0= ruleObject
                    	    {

                    	    					newCompositeNode(grammarAccess.getModelAccess().getObjectsObjectParserRuleCall_6_0());
                    	    				
                    	    pushFollow(FOLLOW_8);
                    	    lv_objects_8_0=ruleObject();

                    	    state._fsp--;


                    	    					if (current==null) {
                    	    						current = createModelElementForParent(grammarAccess.getModelRule());
                    	    					}
                    	    					add(
                    	    						current,
                    	    						"objects",
                    	    						lv_objects_8_0,
                    	    						"org.xtext.example.mydsl.Sparrow.Object");
                    	    					afterParserOrEnumRuleCall();
                    	    				

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    // InternalSparrow.g:191:3: ( (lv_group_9_0= ruleGroup ) )*
                    loop5:
                    do {
                        int alt5=2;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0==40) ) {
                            alt5=1;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalSparrow.g:192:4: (lv_group_9_0= ruleGroup )
                    	    {
                    	    // InternalSparrow.g:192:4: (lv_group_9_0= ruleGroup )
                    	    // InternalSparrow.g:193:5: lv_group_9_0= ruleGroup
                    	    {

                    	    					newCompositeNode(grammarAccess.getModelAccess().getGroupGroupParserRuleCall_7_0());
                    	    				
                    	    pushFollow(FOLLOW_9);
                    	    lv_group_9_0=ruleGroup();

                    	    state._fsp--;


                    	    					if (current==null) {
                    	    						current = createModelElementForParent(grammarAccess.getModelRule());
                    	    					}
                    	    					add(
                    	    						current,
                    	    						"group",
                    	    						lv_group_9_0,
                    	    						"org.xtext.example.mydsl.Sparrow.Group");
                    	    					afterParserOrEnumRuleCall();
                    	    				

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    // InternalSparrow.g:210:3: ( (lv_initialize_10_0= ruleInitialize ) )?
                    int alt6=2;
                    int LA6_0 = input.LA(1);

                    if ( (LA6_0==36) ) {
                        alt6=1;
                    }
                    switch (alt6) {
                        case 1 :
                            // InternalSparrow.g:211:4: (lv_initialize_10_0= ruleInitialize )
                            {
                            // InternalSparrow.g:211:4: (lv_initialize_10_0= ruleInitialize )
                            // InternalSparrow.g:212:5: lv_initialize_10_0= ruleInitialize
                            {

                            					newCompositeNode(grammarAccess.getModelAccess().getInitializeInitializeParserRuleCall_8_0());
                            				
                            pushFollow(FOLLOW_10);
                            lv_initialize_10_0=ruleInitialize();

                            state._fsp--;


                            					if (current==null) {
                            						current = createModelElementForParent(grammarAccess.getModelRule());
                            					}
                            					set(
                            						current,
                            						"initialize",
                            						lv_initialize_10_0,
                            						"org.xtext.example.mydsl.Sparrow.Initialize");
                            					afterParserOrEnumRuleCall();
                            				

                            }


                            }
                            break;

                    }

                    // InternalSparrow.g:229:3: ( (lv_contractMessage_11_0= ruleContractMessage ) )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==45) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // InternalSparrow.g:230:4: (lv_contractMessage_11_0= ruleContractMessage )
                            {
                            // InternalSparrow.g:230:4: (lv_contractMessage_11_0= ruleContractMessage )
                            // InternalSparrow.g:231:5: lv_contractMessage_11_0= ruleContractMessage
                            {

                            					newCompositeNode(grammarAccess.getModelAccess().getContractMessageContractMessageParserRuleCall_9_0());
                            				
                            pushFollow(FOLLOW_11);
                            lv_contractMessage_11_0=ruleContractMessage();

                            state._fsp--;


                            					if (current==null) {
                            						current = createModelElementForParent(grammarAccess.getModelRule());
                            					}
                            					set(
                            						current,
                            						"contractMessage",
                            						lv_contractMessage_11_0,
                            						"org.xtext.example.mydsl.Sparrow.ContractMessage");
                            					afterParserOrEnumRuleCall();
                            				

                            }


                            }
                            break;

                    }

                    // InternalSparrow.g:248:3: ( (lv_Conditions_12_0= ruleCondition ) )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==66) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // InternalSparrow.g:249:4: (lv_Conditions_12_0= ruleCondition )
                            {
                            // InternalSparrow.g:249:4: (lv_Conditions_12_0= ruleCondition )
                            // InternalSparrow.g:250:5: lv_Conditions_12_0= ruleCondition
                            {

                            					newCompositeNode(grammarAccess.getModelAccess().getConditionsConditionParserRuleCall_10_0());
                            				
                            pushFollow(FOLLOW_12);
                            lv_Conditions_12_0=ruleCondition();

                            state._fsp--;


                            					if (current==null) {
                            						current = createModelElementForParent(grammarAccess.getModelRule());
                            					}
                            					set(
                            						current,
                            						"Conditions",
                            						lv_Conditions_12_0,
                            						"org.xtext.example.mydsl.Sparrow.Condition");
                            					afterParserOrEnumRuleCall();
                            				

                            }


                            }
                            break;

                    }

                    // InternalSparrow.g:267:3: ( (lv_operations_13_0= ruleOperation ) )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==71) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // InternalSparrow.g:268:4: (lv_operations_13_0= ruleOperation )
                            {
                            // InternalSparrow.g:268:4: (lv_operations_13_0= ruleOperation )
                            // InternalSparrow.g:269:5: lv_operations_13_0= ruleOperation
                            {

                            					newCompositeNode(grammarAccess.getModelAccess().getOperationsOperationParserRuleCall_11_0());
                            				
                            pushFollow(FOLLOW_13);
                            lv_operations_13_0=ruleOperation();

                            state._fsp--;


                            					if (current==null) {
                            						current = createModelElementForParent(grammarAccess.getModelRule());
                            					}
                            					set(
                            						current,
                            						"operations",
                            						lv_operations_13_0,
                            						"org.xtext.example.mydsl.Sparrow.Operation");
                            					afterParserOrEnumRuleCall();
                            				

                            }


                            }
                            break;

                    }

                    // InternalSparrow.g:286:3: ( (lv_ruleStructures_14_0= ruleRuleStructure ) )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==72) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // InternalSparrow.g:287:4: (lv_ruleStructures_14_0= ruleRuleStructure )
                            {
                            // InternalSparrow.g:287:4: (lv_ruleStructures_14_0= ruleRuleStructure )
                            // InternalSparrow.g:288:5: lv_ruleStructures_14_0= ruleRuleStructure
                            {

                            					newCompositeNode(grammarAccess.getModelAccess().getRuleStructuresRuleStructureParserRuleCall_12_0());
                            				
                            pushFollow(FOLLOW_14);
                            lv_ruleStructures_14_0=ruleRuleStructure();

                            state._fsp--;


                            					if (current==null) {
                            						current = createModelElementForParent(grammarAccess.getModelRule());
                            					}
                            					set(
                            						current,
                            						"ruleStructures",
                            						lv_ruleStructures_14_0,
                            						"org.xtext.example.mydsl.Sparrow.RuleStructure");
                            					afterParserOrEnumRuleCall();
                            				

                            }


                            }
                            break;

                    }

                    // InternalSparrow.g:305:3: ( (lv_require_15_0= ruleRequire ) )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==20) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // InternalSparrow.g:306:4: (lv_require_15_0= ruleRequire )
                            {
                            // InternalSparrow.g:306:4: (lv_require_15_0= ruleRequire )
                            // InternalSparrow.g:307:5: lv_require_15_0= ruleRequire
                            {

                            					newCompositeNode(grammarAccess.getModelAccess().getRequireRequireParserRuleCall_13_0());
                            				
                            pushFollow(FOLLOW_15);
                            lv_require_15_0=ruleRequire();

                            state._fsp--;


                            					if (current==null) {
                            						current = createModelElementForParent(grammarAccess.getModelRule());
                            					}
                            					set(
                            						current,
                            						"require",
                            						lv_require_15_0,
                            						"org.xtext.example.mydsl.Sparrow.Require");
                            					afterParserOrEnumRuleCall();
                            				

                            }


                            }
                            break;

                    }

                    otherlv_16=(Token)match(input,19,FOLLOW_2); 

                    			newLeafNode(otherlv_16, grammarAccess.getModelAccess().getRightCurlyBracketKeyword_14());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleRequire"
    // InternalSparrow.g:332:1: entryRuleRequire returns [EObject current=null] : iv_ruleRequire= ruleRequire EOF ;
    public final EObject entryRuleRequire() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRequire = null;


        try {
            // InternalSparrow.g:332:48: (iv_ruleRequire= ruleRequire EOF )
            // InternalSparrow.g:333:2: iv_ruleRequire= ruleRequire EOF
            {
             newCompositeNode(grammarAccess.getRequireRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRequire=ruleRequire();

            state._fsp--;

             current =iv_ruleRequire; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRequire"


    // $ANTLR start "ruleRequire"
    // InternalSparrow.g:339:1: ruleRequire returns [EObject current=null] : (otherlv_0= 'Require' otherlv_1= ':' ( ( (lv_value_2_1= ruleconditiontype | lv_value_2_2= ruleactiontype ) ) ) (otherlv_3= ',' ( ( (lv_value_4_1= ruleconditiontype | lv_value_4_2= ruleactiontype ) ) ) )* otherlv_5= ';' ) ;
    public final EObject ruleRequire() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_value_2_1 = null;

        AntlrDatatypeRuleToken lv_value_2_2 = null;

        AntlrDatatypeRuleToken lv_value_4_1 = null;

        AntlrDatatypeRuleToken lv_value_4_2 = null;



        	enterRule();

        try {
            // InternalSparrow.g:345:2: ( (otherlv_0= 'Require' otherlv_1= ':' ( ( (lv_value_2_1= ruleconditiontype | lv_value_2_2= ruleactiontype ) ) ) (otherlv_3= ',' ( ( (lv_value_4_1= ruleconditiontype | lv_value_4_2= ruleactiontype ) ) ) )* otherlv_5= ';' ) )
            // InternalSparrow.g:346:2: (otherlv_0= 'Require' otherlv_1= ':' ( ( (lv_value_2_1= ruleconditiontype | lv_value_2_2= ruleactiontype ) ) ) (otherlv_3= ',' ( ( (lv_value_4_1= ruleconditiontype | lv_value_4_2= ruleactiontype ) ) ) )* otherlv_5= ';' )
            {
            // InternalSparrow.g:346:2: (otherlv_0= 'Require' otherlv_1= ':' ( ( (lv_value_2_1= ruleconditiontype | lv_value_2_2= ruleactiontype ) ) ) (otherlv_3= ',' ( ( (lv_value_4_1= ruleconditiontype | lv_value_4_2= ruleactiontype ) ) ) )* otherlv_5= ';' )
            // InternalSparrow.g:347:3: otherlv_0= 'Require' otherlv_1= ':' ( ( (lv_value_2_1= ruleconditiontype | lv_value_2_2= ruleactiontype ) ) ) (otherlv_3= ',' ( ( (lv_value_4_1= ruleconditiontype | lv_value_4_2= ruleactiontype ) ) ) )* otherlv_5= ';'
            {
            otherlv_0=(Token)match(input,20,FOLLOW_16); 

            			newLeafNode(otherlv_0, grammarAccess.getRequireAccess().getRequireKeyword_0());
            		
            otherlv_1=(Token)match(input,21,FOLLOW_17); 

            			newLeafNode(otherlv_1, grammarAccess.getRequireAccess().getColonKeyword_1());
            		
            // InternalSparrow.g:355:3: ( ( (lv_value_2_1= ruleconditiontype | lv_value_2_2= ruleactiontype ) ) )
            // InternalSparrow.g:356:4: ( (lv_value_2_1= ruleconditiontype | lv_value_2_2= ruleactiontype ) )
            {
            // InternalSparrow.g:356:4: ( (lv_value_2_1= ruleconditiontype | lv_value_2_2= ruleactiontype ) )
            // InternalSparrow.g:357:5: (lv_value_2_1= ruleconditiontype | lv_value_2_2= ruleactiontype )
            {
            // InternalSparrow.g:357:5: (lv_value_2_1= ruleconditiontype | lv_value_2_2= ruleactiontype )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( ((LA13_0>=24 && LA13_0<=33)) ) {
                alt13=1;
            }
            else if ( ((LA13_0>=34 && LA13_0<=35)) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // InternalSparrow.g:358:6: lv_value_2_1= ruleconditiontype
                    {

                    						newCompositeNode(grammarAccess.getRequireAccess().getValueConditiontypeParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_18);
                    lv_value_2_1=ruleconditiontype();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRequireRule());
                    						}
                    						add(
                    							current,
                    							"value",
                    							lv_value_2_1,
                    							"org.xtext.example.mydsl.Sparrow.conditiontype");
                    						afterParserOrEnumRuleCall();
                    					

                    }
                    break;
                case 2 :
                    // InternalSparrow.g:374:6: lv_value_2_2= ruleactiontype
                    {

                    						newCompositeNode(grammarAccess.getRequireAccess().getValueActiontypeParserRuleCall_2_0_1());
                    					
                    pushFollow(FOLLOW_18);
                    lv_value_2_2=ruleactiontype();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getRequireRule());
                    						}
                    						add(
                    							current,
                    							"value",
                    							lv_value_2_2,
                    							"org.xtext.example.mydsl.Sparrow.actiontype");
                    						afterParserOrEnumRuleCall();
                    					

                    }
                    break;

            }


            }


            }

            // InternalSparrow.g:392:3: (otherlv_3= ',' ( ( (lv_value_4_1= ruleconditiontype | lv_value_4_2= ruleactiontype ) ) ) )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==22) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // InternalSparrow.g:393:4: otherlv_3= ',' ( ( (lv_value_4_1= ruleconditiontype | lv_value_4_2= ruleactiontype ) ) )
            	    {
            	    otherlv_3=(Token)match(input,22,FOLLOW_17); 

            	    				newLeafNode(otherlv_3, grammarAccess.getRequireAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalSparrow.g:397:4: ( ( (lv_value_4_1= ruleconditiontype | lv_value_4_2= ruleactiontype ) ) )
            	    // InternalSparrow.g:398:5: ( (lv_value_4_1= ruleconditiontype | lv_value_4_2= ruleactiontype ) )
            	    {
            	    // InternalSparrow.g:398:5: ( (lv_value_4_1= ruleconditiontype | lv_value_4_2= ruleactiontype ) )
            	    // InternalSparrow.g:399:6: (lv_value_4_1= ruleconditiontype | lv_value_4_2= ruleactiontype )
            	    {
            	    // InternalSparrow.g:399:6: (lv_value_4_1= ruleconditiontype | lv_value_4_2= ruleactiontype )
            	    int alt14=2;
            	    int LA14_0 = input.LA(1);

            	    if ( ((LA14_0>=24 && LA14_0<=33)) ) {
            	        alt14=1;
            	    }
            	    else if ( ((LA14_0>=34 && LA14_0<=35)) ) {
            	        alt14=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 14, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt14) {
            	        case 1 :
            	            // InternalSparrow.g:400:7: lv_value_4_1= ruleconditiontype
            	            {

            	            							newCompositeNode(grammarAccess.getRequireAccess().getValueConditiontypeParserRuleCall_3_1_0_0());
            	            						
            	            pushFollow(FOLLOW_18);
            	            lv_value_4_1=ruleconditiontype();

            	            state._fsp--;


            	            							if (current==null) {
            	            								current = createModelElementForParent(grammarAccess.getRequireRule());
            	            							}
            	            							add(
            	            								current,
            	            								"value",
            	            								lv_value_4_1,
            	            								"org.xtext.example.mydsl.Sparrow.conditiontype");
            	            							afterParserOrEnumRuleCall();
            	            						

            	            }
            	            break;
            	        case 2 :
            	            // InternalSparrow.g:416:7: lv_value_4_2= ruleactiontype
            	            {

            	            							newCompositeNode(grammarAccess.getRequireAccess().getValueActiontypeParserRuleCall_3_1_0_1());
            	            						
            	            pushFollow(FOLLOW_18);
            	            lv_value_4_2=ruleactiontype();

            	            state._fsp--;


            	            							if (current==null) {
            	            								current = createModelElementForParent(grammarAccess.getRequireRule());
            	            							}
            	            							add(
            	            								current,
            	            								"value",
            	            								lv_value_4_2,
            	            								"org.xtext.example.mydsl.Sparrow.actiontype");
            	            							afterParserOrEnumRuleCall();
            	            						

            	            }
            	            break;

            	    }


            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            otherlv_5=(Token)match(input,23,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getRequireAccess().getSemicolonKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRequire"


    // $ANTLR start "entryRuleconditiontype"
    // InternalSparrow.g:443:1: entryRuleconditiontype returns [String current=null] : iv_ruleconditiontype= ruleconditiontype EOF ;
    public final String entryRuleconditiontype() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleconditiontype = null;


        try {
            // InternalSparrow.g:443:53: (iv_ruleconditiontype= ruleconditiontype EOF )
            // InternalSparrow.g:444:2: iv_ruleconditiontype= ruleconditiontype EOF
            {
             newCompositeNode(grammarAccess.getConditiontypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleconditiontype=ruleconditiontype();

            state._fsp--;

             current =iv_ruleconditiontype.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleconditiontype"


    // $ANTLR start "ruleconditiontype"
    // InternalSparrow.g:450:1: ruleconditiontype returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'isTime' | kw= 'isTrue' | kw= 'logic' | kw= 'check' | kw= 'isCompleted' | kw= 'isDone' | kw= 'isRequest' | kw= 'compareString' | kw= 'timeSub' | kw= 'SetDate' ) ;
    public final AntlrDatatypeRuleToken ruleconditiontype() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSparrow.g:456:2: ( (kw= 'isTime' | kw= 'isTrue' | kw= 'logic' | kw= 'check' | kw= 'isCompleted' | kw= 'isDone' | kw= 'isRequest' | kw= 'compareString' | kw= 'timeSub' | kw= 'SetDate' ) )
            // InternalSparrow.g:457:2: (kw= 'isTime' | kw= 'isTrue' | kw= 'logic' | kw= 'check' | kw= 'isCompleted' | kw= 'isDone' | kw= 'isRequest' | kw= 'compareString' | kw= 'timeSub' | kw= 'SetDate' )
            {
            // InternalSparrow.g:457:2: (kw= 'isTime' | kw= 'isTrue' | kw= 'logic' | kw= 'check' | kw= 'isCompleted' | kw= 'isDone' | kw= 'isRequest' | kw= 'compareString' | kw= 'timeSub' | kw= 'SetDate' )
            int alt16=10;
            switch ( input.LA(1) ) {
            case 24:
                {
                alt16=1;
                }
                break;
            case 25:
                {
                alt16=2;
                }
                break;
            case 26:
                {
                alt16=3;
                }
                break;
            case 27:
                {
                alt16=4;
                }
                break;
            case 28:
                {
                alt16=5;
                }
                break;
            case 29:
                {
                alt16=6;
                }
                break;
            case 30:
                {
                alt16=7;
                }
                break;
            case 31:
                {
                alt16=8;
                }
                break;
            case 32:
                {
                alt16=9;
                }
                break;
            case 33:
                {
                alt16=10;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }

            switch (alt16) {
                case 1 :
                    // InternalSparrow.g:458:3: kw= 'isTime'
                    {
                    kw=(Token)match(input,24,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getConditiontypeAccess().getIsTimeKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalSparrow.g:464:3: kw= 'isTrue'
                    {
                    kw=(Token)match(input,25,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getConditiontypeAccess().getIsTrueKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalSparrow.g:470:3: kw= 'logic'
                    {
                    kw=(Token)match(input,26,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getConditiontypeAccess().getLogicKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalSparrow.g:476:3: kw= 'check'
                    {
                    kw=(Token)match(input,27,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getConditiontypeAccess().getCheckKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalSparrow.g:482:3: kw= 'isCompleted'
                    {
                    kw=(Token)match(input,28,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getConditiontypeAccess().getIsCompletedKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalSparrow.g:488:3: kw= 'isDone'
                    {
                    kw=(Token)match(input,29,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getConditiontypeAccess().getIsDoneKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalSparrow.g:494:3: kw= 'isRequest'
                    {
                    kw=(Token)match(input,30,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getConditiontypeAccess().getIsRequestKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalSparrow.g:500:3: kw= 'compareString'
                    {
                    kw=(Token)match(input,31,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getConditiontypeAccess().getCompareStringKeyword_7());
                    		

                    }
                    break;
                case 9 :
                    // InternalSparrow.g:506:3: kw= 'timeSub'
                    {
                    kw=(Token)match(input,32,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getConditiontypeAccess().getTimeSubKeyword_8());
                    		

                    }
                    break;
                case 10 :
                    // InternalSparrow.g:512:3: kw= 'SetDate'
                    {
                    kw=(Token)match(input,33,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getConditiontypeAccess().getSetDateKeyword_9());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleconditiontype"


    // $ANTLR start "entryRuleactiontype"
    // InternalSparrow.g:521:1: entryRuleactiontype returns [String current=null] : iv_ruleactiontype= ruleactiontype EOF ;
    public final String entryRuleactiontype() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleactiontype = null;


        try {
            // InternalSparrow.g:521:50: (iv_ruleactiontype= ruleactiontype EOF )
            // InternalSparrow.g:522:2: iv_ruleactiontype= ruleactiontype EOF
            {
             newCompositeNode(grammarAccess.getActiontypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleactiontype=ruleactiontype();

            state._fsp--;

             current =iv_ruleactiontype.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleactiontype"


    // $ANTLR start "ruleactiontype"
    // InternalSparrow.g:528:1: ruleactiontype returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'transfer' | kw= 'changeState' ) ;
    public final AntlrDatatypeRuleToken ruleactiontype() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSparrow.g:534:2: ( (kw= 'transfer' | kw= 'changeState' ) )
            // InternalSparrow.g:535:2: (kw= 'transfer' | kw= 'changeState' )
            {
            // InternalSparrow.g:535:2: (kw= 'transfer' | kw= 'changeState' )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==34) ) {
                alt17=1;
            }
            else if ( (LA17_0==35) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // InternalSparrow.g:536:3: kw= 'transfer'
                    {
                    kw=(Token)match(input,34,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getActiontypeAccess().getTransferKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalSparrow.g:542:3: kw= 'changeState'
                    {
                    kw=(Token)match(input,35,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getActiontypeAccess().getChangeStateKeyword_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleactiontype"


    // $ANTLR start "entryRuleInitialize"
    // InternalSparrow.g:551:1: entryRuleInitialize returns [EObject current=null] : iv_ruleInitialize= ruleInitialize EOF ;
    public final EObject entryRuleInitialize() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInitialize = null;


        try {
            // InternalSparrow.g:551:51: (iv_ruleInitialize= ruleInitialize EOF )
            // InternalSparrow.g:552:2: iv_ruleInitialize= ruleInitialize EOF
            {
             newCompositeNode(grammarAccess.getInitializeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInitialize=ruleInitialize();

            state._fsp--;

             current =iv_ruleInitialize; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInitialize"


    // $ANTLR start "ruleInitialize"
    // InternalSparrow.g:558:1: ruleInitialize returns [EObject current=null] : ( () otherlv_1= 'Init' otherlv_2= '{' ( (lv_inits_3_0= ruleinitExpressions ) )* otherlv_4= ',' ( (lv_inito_5_0= ruleinitExpressiono ) )* otherlv_6= '}' ) ;
    public final EObject ruleInitialize() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_inits_3_0 = null;

        EObject lv_inito_5_0 = null;



        	enterRule();

        try {
            // InternalSparrow.g:564:2: ( ( () otherlv_1= 'Init' otherlv_2= '{' ( (lv_inits_3_0= ruleinitExpressions ) )* otherlv_4= ',' ( (lv_inito_5_0= ruleinitExpressiono ) )* otherlv_6= '}' ) )
            // InternalSparrow.g:565:2: ( () otherlv_1= 'Init' otherlv_2= '{' ( (lv_inits_3_0= ruleinitExpressions ) )* otherlv_4= ',' ( (lv_inito_5_0= ruleinitExpressiono ) )* otherlv_6= '}' )
            {
            // InternalSparrow.g:565:2: ( () otherlv_1= 'Init' otherlv_2= '{' ( (lv_inits_3_0= ruleinitExpressions ) )* otherlv_4= ',' ( (lv_inito_5_0= ruleinitExpressiono ) )* otherlv_6= '}' )
            // InternalSparrow.g:566:3: () otherlv_1= 'Init' otherlv_2= '{' ( (lv_inits_3_0= ruleinitExpressions ) )* otherlv_4= ',' ( (lv_inito_5_0= ruleinitExpressiono ) )* otherlv_6= '}'
            {
            // InternalSparrow.g:566:3: ()
            // InternalSparrow.g:567:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getInitializeAccess().getInitializeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,36,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getInitializeAccess().getInitKeyword_1());
            		
            otherlv_2=(Token)match(input,18,FOLLOW_19); 

            			newLeafNode(otherlv_2, grammarAccess.getInitializeAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalSparrow.g:581:3: ( (lv_inits_3_0= ruleinitExpressions ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==RULE_ID) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalSparrow.g:582:4: (lv_inits_3_0= ruleinitExpressions )
            	    {
            	    // InternalSparrow.g:582:4: (lv_inits_3_0= ruleinitExpressions )
            	    // InternalSparrow.g:583:5: lv_inits_3_0= ruleinitExpressions
            	    {

            	    					newCompositeNode(grammarAccess.getInitializeAccess().getInitsInitExpressionsParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_19);
            	    lv_inits_3_0=ruleinitExpressions();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getInitializeRule());
            	    					}
            	    					add(
            	    						current,
            	    						"inits",
            	    						lv_inits_3_0,
            	    						"org.xtext.example.mydsl.Sparrow.initExpressions");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            otherlv_4=(Token)match(input,22,FOLLOW_20); 

            			newLeafNode(otherlv_4, grammarAccess.getInitializeAccess().getCommaKeyword_4());
            		
            // InternalSparrow.g:604:3: ( (lv_inito_5_0= ruleinitExpressiono ) )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==RULE_ID) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // InternalSparrow.g:605:4: (lv_inito_5_0= ruleinitExpressiono )
            	    {
            	    // InternalSparrow.g:605:4: (lv_inito_5_0= ruleinitExpressiono )
            	    // InternalSparrow.g:606:5: lv_inito_5_0= ruleinitExpressiono
            	    {

            	    					newCompositeNode(grammarAccess.getInitializeAccess().getInitoInitExpressionoParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_20);
            	    lv_inito_5_0=ruleinitExpressiono();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getInitializeRule());
            	    					}
            	    					add(
            	    						current,
            	    						"inito",
            	    						lv_inito_5_0,
            	    						"org.xtext.example.mydsl.Sparrow.initExpressiono");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            otherlv_6=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getInitializeAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInitialize"


    // $ANTLR start "entryRuleinitExpressions"
    // InternalSparrow.g:631:1: entryRuleinitExpressions returns [EObject current=null] : iv_ruleinitExpressions= ruleinitExpressions EOF ;
    public final EObject entryRuleinitExpressions() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleinitExpressions = null;


        try {
            // InternalSparrow.g:631:56: (iv_ruleinitExpressions= ruleinitExpressions EOF )
            // InternalSparrow.g:632:2: iv_ruleinitExpressions= ruleinitExpressions EOF
            {
             newCompositeNode(grammarAccess.getInitExpressionsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleinitExpressions=ruleinitExpressions();

            state._fsp--;

             current =iv_ruleinitExpressions; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleinitExpressions"


    // $ANTLR start "ruleinitExpressions"
    // InternalSparrow.g:638:1: ruleinitExpressions returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' otherlv_3= '(' ( (lv_value_4_0= ruleValue ) ) (otherlv_5= ',' ( (lv_value_6_0= ruleValue ) ) )* otherlv_7= ')' ) ;
    public final EObject ruleinitExpressions() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_value_4_0 = null;

        EObject lv_value_6_0 = null;



        	enterRule();

        try {
            // InternalSparrow.g:644:2: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' otherlv_3= '(' ( (lv_value_4_0= ruleValue ) ) (otherlv_5= ',' ( (lv_value_6_0= ruleValue ) ) )* otherlv_7= ')' ) )
            // InternalSparrow.g:645:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' otherlv_3= '(' ( (lv_value_4_0= ruleValue ) ) (otherlv_5= ',' ( (lv_value_6_0= ruleValue ) ) )* otherlv_7= ')' )
            {
            // InternalSparrow.g:645:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' otherlv_3= '(' ( (lv_value_4_0= ruleValue ) ) (otherlv_5= ',' ( (lv_value_6_0= ruleValue ) ) )* otherlv_7= ')' )
            // InternalSparrow.g:646:3: ( (otherlv_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' otherlv_3= '(' ( (lv_value_4_0= ruleValue ) ) (otherlv_5= ',' ( (lv_value_6_0= ruleValue ) ) )* otherlv_7= ')'
            {
            // InternalSparrow.g:646:3: ( (otherlv_0= RULE_ID ) )
            // InternalSparrow.g:647:4: (otherlv_0= RULE_ID )
            {
            // InternalSparrow.g:647:4: (otherlv_0= RULE_ID )
            // InternalSparrow.g:648:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInitExpressionsRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_3); 

            					newLeafNode(otherlv_0, grammarAccess.getInitExpressionsAccess().getSubtypeSubjectCrossReference_0_0());
            				

            }


            }

            // InternalSparrow.g:659:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSparrow.g:660:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSparrow.g:660:4: (lv_name_1_0= RULE_ID )
            // InternalSparrow.g:661:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_21); 

            					newLeafNode(lv_name_1_0, grammarAccess.getInitExpressionsAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInitExpressionsRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,37,FOLLOW_22); 

            			newLeafNode(otherlv_2, grammarAccess.getInitExpressionsAccess().getEqualsSignKeyword_2());
            		
            otherlv_3=(Token)match(input,38,FOLLOW_23); 

            			newLeafNode(otherlv_3, grammarAccess.getInitExpressionsAccess().getLeftParenthesisKeyword_3());
            		
            // InternalSparrow.g:685:3: ( (lv_value_4_0= ruleValue ) )
            // InternalSparrow.g:686:4: (lv_value_4_0= ruleValue )
            {
            // InternalSparrow.g:686:4: (lv_value_4_0= ruleValue )
            // InternalSparrow.g:687:5: lv_value_4_0= ruleValue
            {

            					newCompositeNode(grammarAccess.getInitExpressionsAccess().getValueValueParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_24);
            lv_value_4_0=ruleValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getInitExpressionsRule());
            					}
            					add(
            						current,
            						"value",
            						lv_value_4_0,
            						"org.xtext.example.mydsl.Sparrow.Value");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSparrow.g:704:3: (otherlv_5= ',' ( (lv_value_6_0= ruleValue ) ) )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==22) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // InternalSparrow.g:705:4: otherlv_5= ',' ( (lv_value_6_0= ruleValue ) )
            	    {
            	    otherlv_5=(Token)match(input,22,FOLLOW_23); 

            	    				newLeafNode(otherlv_5, grammarAccess.getInitExpressionsAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalSparrow.g:709:4: ( (lv_value_6_0= ruleValue ) )
            	    // InternalSparrow.g:710:5: (lv_value_6_0= ruleValue )
            	    {
            	    // InternalSparrow.g:710:5: (lv_value_6_0= ruleValue )
            	    // InternalSparrow.g:711:6: lv_value_6_0= ruleValue
            	    {

            	    						newCompositeNode(grammarAccess.getInitExpressionsAccess().getValueValueParserRuleCall_5_1_0());
            	    					
            	    pushFollow(FOLLOW_24);
            	    lv_value_6_0=ruleValue();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getInitExpressionsRule());
            	    						}
            	    						add(
            	    							current,
            	    							"value",
            	    							lv_value_6_0,
            	    							"org.xtext.example.mydsl.Sparrow.Value");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            otherlv_7=(Token)match(input,39,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getInitExpressionsAccess().getRightParenthesisKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleinitExpressions"


    // $ANTLR start "entryRuleinitExpressiono"
    // InternalSparrow.g:737:1: entryRuleinitExpressiono returns [EObject current=null] : iv_ruleinitExpressiono= ruleinitExpressiono EOF ;
    public final EObject entryRuleinitExpressiono() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleinitExpressiono = null;


        try {
            // InternalSparrow.g:737:56: (iv_ruleinitExpressiono= ruleinitExpressiono EOF )
            // InternalSparrow.g:738:2: iv_ruleinitExpressiono= ruleinitExpressiono EOF
            {
             newCompositeNode(grammarAccess.getInitExpressionoRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleinitExpressiono=ruleinitExpressiono();

            state._fsp--;

             current =iv_ruleinitExpressiono; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleinitExpressiono"


    // $ANTLR start "ruleinitExpressiono"
    // InternalSparrow.g:744:1: ruleinitExpressiono returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' otherlv_3= '(' ( (lv_value_4_0= ruleValue ) ) (otherlv_5= ',' ( (lv_value_6_0= ruleValue ) ) )* otherlv_7= ')' ) ;
    public final EObject ruleinitExpressiono() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_value_4_0 = null;

        EObject lv_value_6_0 = null;



        	enterRule();

        try {
            // InternalSparrow.g:750:2: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' otherlv_3= '(' ( (lv_value_4_0= ruleValue ) ) (otherlv_5= ',' ( (lv_value_6_0= ruleValue ) ) )* otherlv_7= ')' ) )
            // InternalSparrow.g:751:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' otherlv_3= '(' ( (lv_value_4_0= ruleValue ) ) (otherlv_5= ',' ( (lv_value_6_0= ruleValue ) ) )* otherlv_7= ')' )
            {
            // InternalSparrow.g:751:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' otherlv_3= '(' ( (lv_value_4_0= ruleValue ) ) (otherlv_5= ',' ( (lv_value_6_0= ruleValue ) ) )* otherlv_7= ')' )
            // InternalSparrow.g:752:3: ( (otherlv_0= RULE_ID ) ) ( (lv_name_1_0= RULE_ID ) ) otherlv_2= '=' otherlv_3= '(' ( (lv_value_4_0= ruleValue ) ) (otherlv_5= ',' ( (lv_value_6_0= ruleValue ) ) )* otherlv_7= ')'
            {
            // InternalSparrow.g:752:3: ( (otherlv_0= RULE_ID ) )
            // InternalSparrow.g:753:4: (otherlv_0= RULE_ID )
            {
            // InternalSparrow.g:753:4: (otherlv_0= RULE_ID )
            // InternalSparrow.g:754:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInitExpressionoRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_3); 

            					newLeafNode(otherlv_0, grammarAccess.getInitExpressionoAccess().getObtypeObjectCrossReference_0_0());
            				

            }


            }

            // InternalSparrow.g:765:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSparrow.g:766:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSparrow.g:766:4: (lv_name_1_0= RULE_ID )
            // InternalSparrow.g:767:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_21); 

            					newLeafNode(lv_name_1_0, grammarAccess.getInitExpressionoAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInitExpressionoRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,37,FOLLOW_22); 

            			newLeafNode(otherlv_2, grammarAccess.getInitExpressionoAccess().getEqualsSignKeyword_2());
            		
            otherlv_3=(Token)match(input,38,FOLLOW_23); 

            			newLeafNode(otherlv_3, grammarAccess.getInitExpressionoAccess().getLeftParenthesisKeyword_3());
            		
            // InternalSparrow.g:791:3: ( (lv_value_4_0= ruleValue ) )
            // InternalSparrow.g:792:4: (lv_value_4_0= ruleValue )
            {
            // InternalSparrow.g:792:4: (lv_value_4_0= ruleValue )
            // InternalSparrow.g:793:5: lv_value_4_0= ruleValue
            {

            					newCompositeNode(grammarAccess.getInitExpressionoAccess().getValueValueParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_24);
            lv_value_4_0=ruleValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getInitExpressionoRule());
            					}
            					add(
            						current,
            						"value",
            						lv_value_4_0,
            						"org.xtext.example.mydsl.Sparrow.Value");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSparrow.g:810:3: (otherlv_5= ',' ( (lv_value_6_0= ruleValue ) ) )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==22) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // InternalSparrow.g:811:4: otherlv_5= ',' ( (lv_value_6_0= ruleValue ) )
            	    {
            	    otherlv_5=(Token)match(input,22,FOLLOW_23); 

            	    				newLeafNode(otherlv_5, grammarAccess.getInitExpressionoAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalSparrow.g:815:4: ( (lv_value_6_0= ruleValue ) )
            	    // InternalSparrow.g:816:5: (lv_value_6_0= ruleValue )
            	    {
            	    // InternalSparrow.g:816:5: (lv_value_6_0= ruleValue )
            	    // InternalSparrow.g:817:6: lv_value_6_0= ruleValue
            	    {

            	    						newCompositeNode(grammarAccess.getInitExpressionoAccess().getValueValueParserRuleCall_5_1_0());
            	    					
            	    pushFollow(FOLLOW_24);
            	    lv_value_6_0=ruleValue();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getInitExpressionoRule());
            	    						}
            	    						add(
            	    							current,
            	    							"value",
            	    							lv_value_6_0,
            	    							"org.xtext.example.mydsl.Sparrow.Value");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            otherlv_7=(Token)match(input,39,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getInitExpressionoAccess().getRightParenthesisKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleinitExpressiono"


    // $ANTLR start "entryRuleGroup"
    // InternalSparrow.g:843:1: entryRuleGroup returns [EObject current=null] : iv_ruleGroup= ruleGroup EOF ;
    public final EObject entryRuleGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGroup = null;


        try {
            // InternalSparrow.g:843:46: (iv_ruleGroup= ruleGroup EOF )
            // InternalSparrow.g:844:2: iv_ruleGroup= ruleGroup EOF
            {
             newCompositeNode(grammarAccess.getGroupRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGroup=ruleGroup();

            state._fsp--;

             current =iv_ruleGroup; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGroup"


    // $ANTLR start "ruleGroup"
    // InternalSparrow.g:850:1: ruleGroup returns [EObject current=null] : (otherlv_0= 'Group' ( (otherlv_1= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= '}' ) ;
    public final EObject ruleGroup() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;


        	enterRule();

        try {
            // InternalSparrow.g:856:2: ( (otherlv_0= 'Group' ( (otherlv_1= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= '}' ) )
            // InternalSparrow.g:857:2: (otherlv_0= 'Group' ( (otherlv_1= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= '}' )
            {
            // InternalSparrow.g:857:2: (otherlv_0= 'Group' ( (otherlv_1= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= '}' )
            // InternalSparrow.g:858:3: otherlv_0= 'Group' ( (otherlv_1= RULE_ID ) ) ( (lv_name_2_0= RULE_ID ) ) otherlv_3= '{' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,40,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getGroupAccess().getGroupKeyword_0());
            		
            // InternalSparrow.g:862:3: ( (otherlv_1= RULE_ID ) )
            // InternalSparrow.g:863:4: (otherlv_1= RULE_ID )
            {
            // InternalSparrow.g:863:4: (otherlv_1= RULE_ID )
            // InternalSparrow.g:864:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGroupRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_3); 

            					newLeafNode(otherlv_1, grammarAccess.getGroupAccess().getSubtypeSubjectCrossReference_1_0());
            				

            }


            }

            // InternalSparrow.g:875:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalSparrow.g:876:4: (lv_name_2_0= RULE_ID )
            {
            // InternalSparrow.g:876:4: (lv_name_2_0= RULE_ID )
            // InternalSparrow.g:877:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_6); 

            					newLeafNode(lv_name_2_0, grammarAccess.getGroupAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGroupRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_3=(Token)match(input,18,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getGroupAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalSparrow.g:897:3: ( (otherlv_4= RULE_ID ) )
            // InternalSparrow.g:898:4: (otherlv_4= RULE_ID )
            {
            // InternalSparrow.g:898:4: (otherlv_4= RULE_ID )
            // InternalSparrow.g:899:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGroupRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_25); 

            					newLeafNode(otherlv_4, grammarAccess.getGroupAccess().getValueInitExpressionsCrossReference_4_0());
            				

            }


            }

            // InternalSparrow.g:910:3: (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==22) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalSparrow.g:911:4: otherlv_5= ',' ( (otherlv_6= RULE_ID ) )
            	    {
            	    otherlv_5=(Token)match(input,22,FOLLOW_3); 

            	    				newLeafNode(otherlv_5, grammarAccess.getGroupAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalSparrow.g:915:4: ( (otherlv_6= RULE_ID ) )
            	    // InternalSparrow.g:916:5: (otherlv_6= RULE_ID )
            	    {
            	    // InternalSparrow.g:916:5: (otherlv_6= RULE_ID )
            	    // InternalSparrow.g:917:6: otherlv_6= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getGroupRule());
            	    						}
            	    					
            	    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_25); 

            	    						newLeafNode(otherlv_6, grammarAccess.getGroupAccess().getValueInitExpressionsCrossReference_5_1_0());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            otherlv_7=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getGroupAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGroup"


    // $ANTLR start "entryRuleSubject"
    // InternalSparrow.g:937:1: entryRuleSubject returns [EObject current=null] : iv_ruleSubject= ruleSubject EOF ;
    public final EObject entryRuleSubject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubject = null;


        try {
            // InternalSparrow.g:937:48: (iv_ruleSubject= ruleSubject EOF )
            // InternalSparrow.g:938:2: iv_ruleSubject= ruleSubject EOF
            {
             newCompositeNode(grammarAccess.getSubjectRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSubject=ruleSubject();

            state._fsp--;

             current =iv_ruleSubject; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSubject"


    // $ANTLR start "ruleSubject"
    // InternalSparrow.g:944:1: ruleSubject returns [EObject current=null] : ( ( ( (lv_type_0_1= 'RA' | lv_type_0_2= 'AA' | lv_type_0_3= 'CA' | lv_type_0_4= 'PA' ) ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_subjectExpression_2_0= ruleSubjectExpression ) )? ) ;
    public final EObject ruleSubject() throws RecognitionException {
        EObject current = null;

        Token lv_type_0_1=null;
        Token lv_type_0_2=null;
        Token lv_type_0_3=null;
        Token lv_type_0_4=null;
        Token lv_name_1_0=null;
        EObject lv_subjectExpression_2_0 = null;



        	enterRule();

        try {
            // InternalSparrow.g:950:2: ( ( ( ( (lv_type_0_1= 'RA' | lv_type_0_2= 'AA' | lv_type_0_3= 'CA' | lv_type_0_4= 'PA' ) ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_subjectExpression_2_0= ruleSubjectExpression ) )? ) )
            // InternalSparrow.g:951:2: ( ( ( (lv_type_0_1= 'RA' | lv_type_0_2= 'AA' | lv_type_0_3= 'CA' | lv_type_0_4= 'PA' ) ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_subjectExpression_2_0= ruleSubjectExpression ) )? )
            {
            // InternalSparrow.g:951:2: ( ( ( (lv_type_0_1= 'RA' | lv_type_0_2= 'AA' | lv_type_0_3= 'CA' | lv_type_0_4= 'PA' ) ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_subjectExpression_2_0= ruleSubjectExpression ) )? )
            // InternalSparrow.g:952:3: ( ( (lv_type_0_1= 'RA' | lv_type_0_2= 'AA' | lv_type_0_3= 'CA' | lv_type_0_4= 'PA' ) ) ) ( (lv_name_1_0= RULE_ID ) ) ( (lv_subjectExpression_2_0= ruleSubjectExpression ) )?
            {
            // InternalSparrow.g:952:3: ( ( (lv_type_0_1= 'RA' | lv_type_0_2= 'AA' | lv_type_0_3= 'CA' | lv_type_0_4= 'PA' ) ) )
            // InternalSparrow.g:953:4: ( (lv_type_0_1= 'RA' | lv_type_0_2= 'AA' | lv_type_0_3= 'CA' | lv_type_0_4= 'PA' ) )
            {
            // InternalSparrow.g:953:4: ( (lv_type_0_1= 'RA' | lv_type_0_2= 'AA' | lv_type_0_3= 'CA' | lv_type_0_4= 'PA' ) )
            // InternalSparrow.g:954:5: (lv_type_0_1= 'RA' | lv_type_0_2= 'AA' | lv_type_0_3= 'CA' | lv_type_0_4= 'PA' )
            {
            // InternalSparrow.g:954:5: (lv_type_0_1= 'RA' | lv_type_0_2= 'AA' | lv_type_0_3= 'CA' | lv_type_0_4= 'PA' )
            int alt23=4;
            switch ( input.LA(1) ) {
            case 41:
                {
                alt23=1;
                }
                break;
            case 42:
                {
                alt23=2;
                }
                break;
            case 43:
                {
                alt23=3;
                }
                break;
            case 44:
                {
                alt23=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // InternalSparrow.g:955:6: lv_type_0_1= 'RA'
                    {
                    lv_type_0_1=(Token)match(input,41,FOLLOW_3); 

                    						newLeafNode(lv_type_0_1, grammarAccess.getSubjectAccess().getTypeRAKeyword_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getSubjectRule());
                    						}
                    						setWithLastConsumed(current, "type", lv_type_0_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalSparrow.g:966:6: lv_type_0_2= 'AA'
                    {
                    lv_type_0_2=(Token)match(input,42,FOLLOW_3); 

                    						newLeafNode(lv_type_0_2, grammarAccess.getSubjectAccess().getTypeAAKeyword_0_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getSubjectRule());
                    						}
                    						setWithLastConsumed(current, "type", lv_type_0_2, null);
                    					

                    }
                    break;
                case 3 :
                    // InternalSparrow.g:977:6: lv_type_0_3= 'CA'
                    {
                    lv_type_0_3=(Token)match(input,43,FOLLOW_3); 

                    						newLeafNode(lv_type_0_3, grammarAccess.getSubjectAccess().getTypeCAKeyword_0_0_2());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getSubjectRule());
                    						}
                    						setWithLastConsumed(current, "type", lv_type_0_3, null);
                    					

                    }
                    break;
                case 4 :
                    // InternalSparrow.g:988:6: lv_type_0_4= 'PA'
                    {
                    lv_type_0_4=(Token)match(input,44,FOLLOW_3); 

                    						newLeafNode(lv_type_0_4, grammarAccess.getSubjectAccess().getTypePAKeyword_0_0_3());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getSubjectRule());
                    						}
                    						setWithLastConsumed(current, "type", lv_type_0_4, null);
                    					

                    }
                    break;

            }


            }


            }

            // InternalSparrow.g:1001:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSparrow.g:1002:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSparrow.g:1002:4: (lv_name_1_0= RULE_ID )
            // InternalSparrow.g:1003:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_26); 

            					newLeafNode(lv_name_1_0, grammarAccess.getSubjectAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSubjectRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalSparrow.g:1019:3: ( (lv_subjectExpression_2_0= ruleSubjectExpression ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==18) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalSparrow.g:1020:4: (lv_subjectExpression_2_0= ruleSubjectExpression )
                    {
                    // InternalSparrow.g:1020:4: (lv_subjectExpression_2_0= ruleSubjectExpression )
                    // InternalSparrow.g:1021:5: lv_subjectExpression_2_0= ruleSubjectExpression
                    {

                    					newCompositeNode(grammarAccess.getSubjectAccess().getSubjectExpressionSubjectExpressionParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_subjectExpression_2_0=ruleSubjectExpression();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getSubjectRule());
                    					}
                    					set(
                    						current,
                    						"subjectExpression",
                    						lv_subjectExpression_2_0,
                    						"org.xtext.example.mydsl.Sparrow.SubjectExpression");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSubject"


    // $ANTLR start "entryRuleSubjectExpression"
    // InternalSparrow.g:1042:1: entryRuleSubjectExpression returns [EObject current=null] : iv_ruleSubjectExpression= ruleSubjectExpression EOF ;
    public final EObject entryRuleSubjectExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubjectExpression = null;


        try {
            // InternalSparrow.g:1042:58: (iv_ruleSubjectExpression= ruleSubjectExpression EOF )
            // InternalSparrow.g:1043:2: iv_ruleSubjectExpression= ruleSubjectExpression EOF
            {
             newCompositeNode(grammarAccess.getSubjectExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSubjectExpression=ruleSubjectExpression();

            state._fsp--;

             current =iv_ruleSubjectExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSubjectExpression"


    // $ANTLR start "ruleSubjectExpression"
    // InternalSparrow.g:1049:1: ruleSubjectExpression returns [EObject current=null] : (otherlv_0= '{' ( (lv_keyValue_1_0= rulekeyvalue ) ) (otherlv_2= ',' ( (lv_keyValue_3_0= rulekeyvalue ) ) )* otherlv_4= '}' ) ;
    public final EObject ruleSubjectExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_keyValue_1_0 = null;

        EObject lv_keyValue_3_0 = null;



        	enterRule();

        try {
            // InternalSparrow.g:1055:2: ( (otherlv_0= '{' ( (lv_keyValue_1_0= rulekeyvalue ) ) (otherlv_2= ',' ( (lv_keyValue_3_0= rulekeyvalue ) ) )* otherlv_4= '}' ) )
            // InternalSparrow.g:1056:2: (otherlv_0= '{' ( (lv_keyValue_1_0= rulekeyvalue ) ) (otherlv_2= ',' ( (lv_keyValue_3_0= rulekeyvalue ) ) )* otherlv_4= '}' )
            {
            // InternalSparrow.g:1056:2: (otherlv_0= '{' ( (lv_keyValue_1_0= rulekeyvalue ) ) (otherlv_2= ',' ( (lv_keyValue_3_0= rulekeyvalue ) ) )* otherlv_4= '}' )
            // InternalSparrow.g:1057:3: otherlv_0= '{' ( (lv_keyValue_1_0= rulekeyvalue ) ) (otherlv_2= ',' ( (lv_keyValue_3_0= rulekeyvalue ) ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_27); 

            			newLeafNode(otherlv_0, grammarAccess.getSubjectExpressionAccess().getLeftCurlyBracketKeyword_0());
            		
            // InternalSparrow.g:1061:3: ( (lv_keyValue_1_0= rulekeyvalue ) )
            // InternalSparrow.g:1062:4: (lv_keyValue_1_0= rulekeyvalue )
            {
            // InternalSparrow.g:1062:4: (lv_keyValue_1_0= rulekeyvalue )
            // InternalSparrow.g:1063:5: lv_keyValue_1_0= rulekeyvalue
            {

            					newCompositeNode(grammarAccess.getSubjectExpressionAccess().getKeyValueKeyvalueParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_25);
            lv_keyValue_1_0=rulekeyvalue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSubjectExpressionRule());
            					}
            					add(
            						current,
            						"keyValue",
            						lv_keyValue_1_0,
            						"org.xtext.example.mydsl.Sparrow.keyvalue");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSparrow.g:1080:3: (otherlv_2= ',' ( (lv_keyValue_3_0= rulekeyvalue ) ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==22) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // InternalSparrow.g:1081:4: otherlv_2= ',' ( (lv_keyValue_3_0= rulekeyvalue ) )
            	    {
            	    otherlv_2=(Token)match(input,22,FOLLOW_27); 

            	    				newLeafNode(otherlv_2, grammarAccess.getSubjectExpressionAccess().getCommaKeyword_2_0());
            	    			
            	    // InternalSparrow.g:1085:4: ( (lv_keyValue_3_0= rulekeyvalue ) )
            	    // InternalSparrow.g:1086:5: (lv_keyValue_3_0= rulekeyvalue )
            	    {
            	    // InternalSparrow.g:1086:5: (lv_keyValue_3_0= rulekeyvalue )
            	    // InternalSparrow.g:1087:6: lv_keyValue_3_0= rulekeyvalue
            	    {

            	    						newCompositeNode(grammarAccess.getSubjectExpressionAccess().getKeyValueKeyvalueParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_25);
            	    lv_keyValue_3_0=rulekeyvalue();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getSubjectExpressionRule());
            	    						}
            	    						add(
            	    							current,
            	    							"keyValue",
            	    							lv_keyValue_3_0,
            	    							"org.xtext.example.mydsl.Sparrow.keyvalue");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            otherlv_4=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getSubjectExpressionAccess().getRightCurlyBracketKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSubjectExpression"


    // $ANTLR start "entryRuleContractMessage"
    // InternalSparrow.g:1113:1: entryRuleContractMessage returns [EObject current=null] : iv_ruleContractMessage= ruleContractMessage EOF ;
    public final EObject entryRuleContractMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContractMessage = null;


        try {
            // InternalSparrow.g:1113:56: (iv_ruleContractMessage= ruleContractMessage EOF )
            // InternalSparrow.g:1114:2: iv_ruleContractMessage= ruleContractMessage EOF
            {
             newCompositeNode(grammarAccess.getContractMessageRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContractMessage=ruleContractMessage();

            state._fsp--;

             current =iv_ruleContractMessage; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContractMessage"


    // $ANTLR start "ruleContractMessage"
    // InternalSparrow.g:1120:1: ruleContractMessage returns [EObject current=null] : (otherlv_0= 'ContractMessage' otherlv_1= '{' ( (lv_message_2_0= ruleMessage ) ) (otherlv_3= ',' ( (lv_message_4_0= ruleMessage ) ) )* otherlv_5= '}' ) ;
    public final EObject ruleContractMessage() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_message_2_0 = null;

        EObject lv_message_4_0 = null;



        	enterRule();

        try {
            // InternalSparrow.g:1126:2: ( (otherlv_0= 'ContractMessage' otherlv_1= '{' ( (lv_message_2_0= ruleMessage ) ) (otherlv_3= ',' ( (lv_message_4_0= ruleMessage ) ) )* otherlv_5= '}' ) )
            // InternalSparrow.g:1127:2: (otherlv_0= 'ContractMessage' otherlv_1= '{' ( (lv_message_2_0= ruleMessage ) ) (otherlv_3= ',' ( (lv_message_4_0= ruleMessage ) ) )* otherlv_5= '}' )
            {
            // InternalSparrow.g:1127:2: (otherlv_0= 'ContractMessage' otherlv_1= '{' ( (lv_message_2_0= ruleMessage ) ) (otherlv_3= ',' ( (lv_message_4_0= ruleMessage ) ) )* otherlv_5= '}' )
            // InternalSparrow.g:1128:3: otherlv_0= 'ContractMessage' otherlv_1= '{' ( (lv_message_2_0= ruleMessage ) ) (otherlv_3= ',' ( (lv_message_4_0= ruleMessage ) ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,45,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getContractMessageAccess().getContractMessageKeyword_0());
            		
            otherlv_1=(Token)match(input,18,FOLLOW_27); 

            			newLeafNode(otherlv_1, grammarAccess.getContractMessageAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalSparrow.g:1136:3: ( (lv_message_2_0= ruleMessage ) )
            // InternalSparrow.g:1137:4: (lv_message_2_0= ruleMessage )
            {
            // InternalSparrow.g:1137:4: (lv_message_2_0= ruleMessage )
            // InternalSparrow.g:1138:5: lv_message_2_0= ruleMessage
            {

            					newCompositeNode(grammarAccess.getContractMessageAccess().getMessageMessageParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_25);
            lv_message_2_0=ruleMessage();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getContractMessageRule());
            					}
            					add(
            						current,
            						"message",
            						lv_message_2_0,
            						"org.xtext.example.mydsl.Sparrow.Message");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSparrow.g:1155:3: (otherlv_3= ',' ( (lv_message_4_0= ruleMessage ) ) )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==22) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // InternalSparrow.g:1156:4: otherlv_3= ',' ( (lv_message_4_0= ruleMessage ) )
            	    {
            	    otherlv_3=(Token)match(input,22,FOLLOW_27); 

            	    				newLeafNode(otherlv_3, grammarAccess.getContractMessageAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalSparrow.g:1160:4: ( (lv_message_4_0= ruleMessage ) )
            	    // InternalSparrow.g:1161:5: (lv_message_4_0= ruleMessage )
            	    {
            	    // InternalSparrow.g:1161:5: (lv_message_4_0= ruleMessage )
            	    // InternalSparrow.g:1162:6: lv_message_4_0= ruleMessage
            	    {

            	    						newCompositeNode(grammarAccess.getContractMessageAccess().getMessageMessageParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_25);
            	    lv_message_4_0=ruleMessage();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getContractMessageRule());
            	    						}
            	    						add(
            	    							current,
            	    							"message",
            	    							lv_message_4_0,
            	    							"org.xtext.example.mydsl.Sparrow.Message");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

            otherlv_5=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getContractMessageAccess().getRightCurlyBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContractMessage"


    // $ANTLR start "entryRuleMessage"
    // InternalSparrow.g:1188:1: entryRuleMessage returns [EObject current=null] : iv_ruleMessage= ruleMessage EOF ;
    public final EObject entryRuleMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMessage = null;


        try {
            // InternalSparrow.g:1188:48: (iv_ruleMessage= ruleMessage EOF )
            // InternalSparrow.g:1189:2: iv_ruleMessage= ruleMessage EOF
            {
             newCompositeNode(grammarAccess.getMessageRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMessage=ruleMessage();

            state._fsp--;

             current =iv_ruleMessage; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMessage"


    // $ANTLR start "ruleMessage"
    // InternalSparrow.g:1195:1: ruleMessage returns [EObject current=null] : ( ( (lv_type_0_0= rulekeyvalue ) ) otherlv_1= '=' ( (lv_value_2_0= ruleValue ) ) ) ;
    public final EObject ruleMessage() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_type_0_0 = null;

        EObject lv_value_2_0 = null;



        	enterRule();

        try {
            // InternalSparrow.g:1201:2: ( ( ( (lv_type_0_0= rulekeyvalue ) ) otherlv_1= '=' ( (lv_value_2_0= ruleValue ) ) ) )
            // InternalSparrow.g:1202:2: ( ( (lv_type_0_0= rulekeyvalue ) ) otherlv_1= '=' ( (lv_value_2_0= ruleValue ) ) )
            {
            // InternalSparrow.g:1202:2: ( ( (lv_type_0_0= rulekeyvalue ) ) otherlv_1= '=' ( (lv_value_2_0= ruleValue ) ) )
            // InternalSparrow.g:1203:3: ( (lv_type_0_0= rulekeyvalue ) ) otherlv_1= '=' ( (lv_value_2_0= ruleValue ) )
            {
            // InternalSparrow.g:1203:3: ( (lv_type_0_0= rulekeyvalue ) )
            // InternalSparrow.g:1204:4: (lv_type_0_0= rulekeyvalue )
            {
            // InternalSparrow.g:1204:4: (lv_type_0_0= rulekeyvalue )
            // InternalSparrow.g:1205:5: lv_type_0_0= rulekeyvalue
            {

            					newCompositeNode(grammarAccess.getMessageAccess().getTypeKeyvalueParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_21);
            lv_type_0_0=rulekeyvalue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMessageRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_0_0,
            						"org.xtext.example.mydsl.Sparrow.keyvalue");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,37,FOLLOW_23); 

            			newLeafNode(otherlv_1, grammarAccess.getMessageAccess().getEqualsSignKeyword_1());
            		
            // InternalSparrow.g:1226:3: ( (lv_value_2_0= ruleValue ) )
            // InternalSparrow.g:1227:4: (lv_value_2_0= ruleValue )
            {
            // InternalSparrow.g:1227:4: (lv_value_2_0= ruleValue )
            // InternalSparrow.g:1228:5: lv_value_2_0= ruleValue
            {

            					newCompositeNode(grammarAccess.getMessageAccess().getValueValueParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_2_0=ruleValue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMessageRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_2_0,
            						"org.xtext.example.mydsl.Sparrow.Value");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMessage"


    // $ANTLR start "entryRulekeyvalue"
    // InternalSparrow.g:1249:1: entryRulekeyvalue returns [EObject current=null] : iv_rulekeyvalue= rulekeyvalue EOF ;
    public final EObject entryRulekeyvalue() throws RecognitionException {
        EObject current = null;

        EObject iv_rulekeyvalue = null;


        try {
            // InternalSparrow.g:1249:49: (iv_rulekeyvalue= rulekeyvalue EOF )
            // InternalSparrow.g:1250:2: iv_rulekeyvalue= rulekeyvalue EOF
            {
             newCompositeNode(grammarAccess.getKeyvalueRule()); 
            pushFollow(FOLLOW_1);
            iv_rulekeyvalue=rulekeyvalue();

            state._fsp--;

             current =iv_rulekeyvalue; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulekeyvalue"


    // $ANTLR start "rulekeyvalue"
    // InternalSparrow.g:1256:1: rulekeyvalue returns [EObject current=null] : ( ( (lv_type_0_0= ruletype ) ) ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject rulekeyvalue() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        AntlrDatatypeRuleToken lv_type_0_0 = null;



        	enterRule();

        try {
            // InternalSparrow.g:1262:2: ( ( ( (lv_type_0_0= ruletype ) ) ( (lv_name_1_0= RULE_ID ) ) ) )
            // InternalSparrow.g:1263:2: ( ( (lv_type_0_0= ruletype ) ) ( (lv_name_1_0= RULE_ID ) ) )
            {
            // InternalSparrow.g:1263:2: ( ( (lv_type_0_0= ruletype ) ) ( (lv_name_1_0= RULE_ID ) ) )
            // InternalSparrow.g:1264:3: ( (lv_type_0_0= ruletype ) ) ( (lv_name_1_0= RULE_ID ) )
            {
            // InternalSparrow.g:1264:3: ( (lv_type_0_0= ruletype ) )
            // InternalSparrow.g:1265:4: (lv_type_0_0= ruletype )
            {
            // InternalSparrow.g:1265:4: (lv_type_0_0= ruletype )
            // InternalSparrow.g:1266:5: lv_type_0_0= ruletype
            {

            					newCompositeNode(grammarAccess.getKeyvalueAccess().getTypeTypeParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_3);
            lv_type_0_0=ruletype();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getKeyvalueRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_0_0,
            						"org.xtext.example.mydsl.Sparrow.type");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSparrow.g:1283:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSparrow.g:1284:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSparrow.g:1284:4: (lv_name_1_0= RULE_ID )
            // InternalSparrow.g:1285:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_name_1_0, grammarAccess.getKeyvalueAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getKeyvalueRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulekeyvalue"


    // $ANTLR start "entryRuletype"
    // InternalSparrow.g:1305:1: entryRuletype returns [String current=null] : iv_ruletype= ruletype EOF ;
    public final String entryRuletype() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruletype = null;


        try {
            // InternalSparrow.g:1305:44: (iv_ruletype= ruletype EOF )
            // InternalSparrow.g:1306:2: iv_ruletype= ruletype EOF
            {
             newCompositeNode(grammarAccess.getTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruletype=ruletype();

            state._fsp--;

             current =iv_ruletype.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuletype"


    // $ANTLR start "ruletype"
    // InternalSparrow.g:1312:1: ruletype returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'string' | kw= 'uint' | kw= 'address' | kw= 'int' | kw= 'bytes' | kw= 'bytes32' | kw= 'bool' | kw= 'fixed' | kw= 'ufixed' | kw= 'date' | kw= 'duration' ) ;
    public final AntlrDatatypeRuleToken ruletype() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSparrow.g:1318:2: ( (kw= 'string' | kw= 'uint' | kw= 'address' | kw= 'int' | kw= 'bytes' | kw= 'bytes32' | kw= 'bool' | kw= 'fixed' | kw= 'ufixed' | kw= 'date' | kw= 'duration' ) )
            // InternalSparrow.g:1319:2: (kw= 'string' | kw= 'uint' | kw= 'address' | kw= 'int' | kw= 'bytes' | kw= 'bytes32' | kw= 'bool' | kw= 'fixed' | kw= 'ufixed' | kw= 'date' | kw= 'duration' )
            {
            // InternalSparrow.g:1319:2: (kw= 'string' | kw= 'uint' | kw= 'address' | kw= 'int' | kw= 'bytes' | kw= 'bytes32' | kw= 'bool' | kw= 'fixed' | kw= 'ufixed' | kw= 'date' | kw= 'duration' )
            int alt27=11;
            switch ( input.LA(1) ) {
            case 46:
                {
                alt27=1;
                }
                break;
            case 47:
                {
                alt27=2;
                }
                break;
            case 48:
                {
                alt27=3;
                }
                break;
            case 49:
                {
                alt27=4;
                }
                break;
            case 50:
                {
                alt27=5;
                }
                break;
            case 51:
                {
                alt27=6;
                }
                break;
            case 52:
                {
                alt27=7;
                }
                break;
            case 53:
                {
                alt27=8;
                }
                break;
            case 54:
                {
                alt27=9;
                }
                break;
            case 55:
                {
                alt27=10;
                }
                break;
            case 56:
                {
                alt27=11;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // InternalSparrow.g:1320:3: kw= 'string'
                    {
                    kw=(Token)match(input,46,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTypeAccess().getStringKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalSparrow.g:1326:3: kw= 'uint'
                    {
                    kw=(Token)match(input,47,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTypeAccess().getUintKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalSparrow.g:1332:3: kw= 'address'
                    {
                    kw=(Token)match(input,48,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTypeAccess().getAddressKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalSparrow.g:1338:3: kw= 'int'
                    {
                    kw=(Token)match(input,49,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTypeAccess().getIntKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalSparrow.g:1344:3: kw= 'bytes'
                    {
                    kw=(Token)match(input,50,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTypeAccess().getBytesKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalSparrow.g:1350:3: kw= 'bytes32'
                    {
                    kw=(Token)match(input,51,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTypeAccess().getBytes32Keyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalSparrow.g:1356:3: kw= 'bool'
                    {
                    kw=(Token)match(input,52,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTypeAccess().getBoolKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalSparrow.g:1362:3: kw= 'fixed'
                    {
                    kw=(Token)match(input,53,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTypeAccess().getFixedKeyword_7());
                    		

                    }
                    break;
                case 9 :
                    // InternalSparrow.g:1368:3: kw= 'ufixed'
                    {
                    kw=(Token)match(input,54,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTypeAccess().getUfixedKeyword_8());
                    		

                    }
                    break;
                case 10 :
                    // InternalSparrow.g:1374:3: kw= 'date'
                    {
                    kw=(Token)match(input,55,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTypeAccess().getDateKeyword_9());
                    		

                    }
                    break;
                case 11 :
                    // InternalSparrow.g:1380:3: kw= 'duration'
                    {
                    kw=(Token)match(input,56,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTypeAccess().getDurationKeyword_10());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruletype"


    // $ANTLR start "entryRuleValue"
    // InternalSparrow.g:1389:1: entryRuleValue returns [EObject current=null] : iv_ruleValue= ruleValue EOF ;
    public final EObject entryRuleValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleValue = null;


        try {
            // InternalSparrow.g:1389:46: (iv_ruleValue= ruleValue EOF )
            // InternalSparrow.g:1390:2: iv_ruleValue= ruleValue EOF
            {
             newCompositeNode(grammarAccess.getValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleValue=ruleValue();

            state._fsp--;

             current =iv_ruleValue; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleValue"


    // $ANTLR start "ruleValue"
    // InternalSparrow.g:1396:1: ruleValue returns [EObject current=null] : (this_AllNumber_0= ruleAllNumber | this_Right_1= ruleRight | this_ThisDate_2= ruleThisDate | this_ThisBoolean_3= ruleThisBoolean | this_url_4= ruleurl | this_ThisDecimal_5= ruleThisDecimal | this_Address_6= ruleAddress | this_ThisString_7= ruleThisString | this_Duration_8= ruleDuration | this_Now_9= ruleNow ) ;
    public final EObject ruleValue() throws RecognitionException {
        EObject current = null;

        EObject this_AllNumber_0 = null;

        EObject this_Right_1 = null;

        EObject this_ThisDate_2 = null;

        EObject this_ThisBoolean_3 = null;

        EObject this_url_4 = null;

        EObject this_ThisDecimal_5 = null;

        EObject this_Address_6 = null;

        EObject this_ThisString_7 = null;

        EObject this_Duration_8 = null;

        EObject this_Now_9 = null;



        	enterRule();

        try {
            // InternalSparrow.g:1402:2: ( (this_AllNumber_0= ruleAllNumber | this_Right_1= ruleRight | this_ThisDate_2= ruleThisDate | this_ThisBoolean_3= ruleThisBoolean | this_url_4= ruleurl | this_ThisDecimal_5= ruleThisDecimal | this_Address_6= ruleAddress | this_ThisString_7= ruleThisString | this_Duration_8= ruleDuration | this_Now_9= ruleNow ) )
            // InternalSparrow.g:1403:2: (this_AllNumber_0= ruleAllNumber | this_Right_1= ruleRight | this_ThisDate_2= ruleThisDate | this_ThisBoolean_3= ruleThisBoolean | this_url_4= ruleurl | this_ThisDecimal_5= ruleThisDecimal | this_Address_6= ruleAddress | this_ThisString_7= ruleThisString | this_Duration_8= ruleDuration | this_Now_9= ruleNow )
            {
            // InternalSparrow.g:1403:2: (this_AllNumber_0= ruleAllNumber | this_Right_1= ruleRight | this_ThisDate_2= ruleThisDate | this_ThisBoolean_3= ruleThisBoolean | this_url_4= ruleurl | this_ThisDecimal_5= ruleThisDecimal | this_Address_6= ruleAddress | this_ThisString_7= ruleThisString | this_Duration_8= ruleDuration | this_Now_9= ruleNow )
            int alt28=10;
            alt28 = dfa28.predict(input);
            switch (alt28) {
                case 1 :
                    // InternalSparrow.g:1404:3: this_AllNumber_0= ruleAllNumber
                    {

                    			newCompositeNode(grammarAccess.getValueAccess().getAllNumberParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_AllNumber_0=ruleAllNumber();

                    state._fsp--;


                    			current = this_AllNumber_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalSparrow.g:1413:3: this_Right_1= ruleRight
                    {

                    			newCompositeNode(grammarAccess.getValueAccess().getRightParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Right_1=ruleRight();

                    state._fsp--;


                    			current = this_Right_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalSparrow.g:1422:3: this_ThisDate_2= ruleThisDate
                    {

                    			newCompositeNode(grammarAccess.getValueAccess().getThisDateParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_ThisDate_2=ruleThisDate();

                    state._fsp--;


                    			current = this_ThisDate_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalSparrow.g:1431:3: this_ThisBoolean_3= ruleThisBoolean
                    {

                    			newCompositeNode(grammarAccess.getValueAccess().getThisBooleanParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_ThisBoolean_3=ruleThisBoolean();

                    state._fsp--;


                    			current = this_ThisBoolean_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalSparrow.g:1440:3: this_url_4= ruleurl
                    {

                    			newCompositeNode(grammarAccess.getValueAccess().getUrlParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_url_4=ruleurl();

                    state._fsp--;


                    			current = this_url_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalSparrow.g:1449:3: this_ThisDecimal_5= ruleThisDecimal
                    {

                    			newCompositeNode(grammarAccess.getValueAccess().getThisDecimalParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_ThisDecimal_5=ruleThisDecimal();

                    state._fsp--;


                    			current = this_ThisDecimal_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalSparrow.g:1458:3: this_Address_6= ruleAddress
                    {

                    			newCompositeNode(grammarAccess.getValueAccess().getAddressParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_Address_6=ruleAddress();

                    state._fsp--;


                    			current = this_Address_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 8 :
                    // InternalSparrow.g:1467:3: this_ThisString_7= ruleThisString
                    {

                    			newCompositeNode(grammarAccess.getValueAccess().getThisStringParserRuleCall_7());
                    		
                    pushFollow(FOLLOW_2);
                    this_ThisString_7=ruleThisString();

                    state._fsp--;


                    			current = this_ThisString_7;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 9 :
                    // InternalSparrow.g:1476:3: this_Duration_8= ruleDuration
                    {

                    			newCompositeNode(grammarAccess.getValueAccess().getDurationParserRuleCall_8());
                    		
                    pushFollow(FOLLOW_2);
                    this_Duration_8=ruleDuration();

                    state._fsp--;


                    			current = this_Duration_8;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 10 :
                    // InternalSparrow.g:1485:3: this_Now_9= ruleNow
                    {

                    			newCompositeNode(grammarAccess.getValueAccess().getNowParserRuleCall_9());
                    		
                    pushFollow(FOLLOW_2);
                    this_Now_9=ruleNow();

                    state._fsp--;


                    			current = this_Now_9;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleValue"


    // $ANTLR start "entryRuleDuration"
    // InternalSparrow.g:1497:1: entryRuleDuration returns [EObject current=null] : iv_ruleDuration= ruleDuration EOF ;
    public final EObject entryRuleDuration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDuration = null;


        try {
            // InternalSparrow.g:1497:49: (iv_ruleDuration= ruleDuration EOF )
            // InternalSparrow.g:1498:2: iv_ruleDuration= ruleDuration EOF
            {
             newCompositeNode(grammarAccess.getDurationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDuration=ruleDuration();

            state._fsp--;

             current =iv_ruleDuration; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDuration"


    // $ANTLR start "ruleDuration"
    // InternalSparrow.g:1504:1: ruleDuration returns [EObject current=null] : ( ( (lv_value_0_0= RULE_INT ) ) ( ( (lv_symbol_1_1= 'years' | lv_symbol_1_2= 'months' | lv_symbol_1_3= 'days' | lv_symbol_1_4= 'hours' | lv_symbol_1_5= 'mins' ) ) ) ) ;
    public final EObject ruleDuration() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;
        Token lv_symbol_1_1=null;
        Token lv_symbol_1_2=null;
        Token lv_symbol_1_3=null;
        Token lv_symbol_1_4=null;
        Token lv_symbol_1_5=null;


        	enterRule();

        try {
            // InternalSparrow.g:1510:2: ( ( ( (lv_value_0_0= RULE_INT ) ) ( ( (lv_symbol_1_1= 'years' | lv_symbol_1_2= 'months' | lv_symbol_1_3= 'days' | lv_symbol_1_4= 'hours' | lv_symbol_1_5= 'mins' ) ) ) ) )
            // InternalSparrow.g:1511:2: ( ( (lv_value_0_0= RULE_INT ) ) ( ( (lv_symbol_1_1= 'years' | lv_symbol_1_2= 'months' | lv_symbol_1_3= 'days' | lv_symbol_1_4= 'hours' | lv_symbol_1_5= 'mins' ) ) ) )
            {
            // InternalSparrow.g:1511:2: ( ( (lv_value_0_0= RULE_INT ) ) ( ( (lv_symbol_1_1= 'years' | lv_symbol_1_2= 'months' | lv_symbol_1_3= 'days' | lv_symbol_1_4= 'hours' | lv_symbol_1_5= 'mins' ) ) ) )
            // InternalSparrow.g:1512:3: ( (lv_value_0_0= RULE_INT ) ) ( ( (lv_symbol_1_1= 'years' | lv_symbol_1_2= 'months' | lv_symbol_1_3= 'days' | lv_symbol_1_4= 'hours' | lv_symbol_1_5= 'mins' ) ) )
            {
            // InternalSparrow.g:1512:3: ( (lv_value_0_0= RULE_INT ) )
            // InternalSparrow.g:1513:4: (lv_value_0_0= RULE_INT )
            {
            // InternalSparrow.g:1513:4: (lv_value_0_0= RULE_INT )
            // InternalSparrow.g:1514:5: lv_value_0_0= RULE_INT
            {
            lv_value_0_0=(Token)match(input,RULE_INT,FOLLOW_28); 

            					newLeafNode(lv_value_0_0, grammarAccess.getDurationAccess().getValueINTTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDurationRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_0_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            // InternalSparrow.g:1530:3: ( ( (lv_symbol_1_1= 'years' | lv_symbol_1_2= 'months' | lv_symbol_1_3= 'days' | lv_symbol_1_4= 'hours' | lv_symbol_1_5= 'mins' ) ) )
            // InternalSparrow.g:1531:4: ( (lv_symbol_1_1= 'years' | lv_symbol_1_2= 'months' | lv_symbol_1_3= 'days' | lv_symbol_1_4= 'hours' | lv_symbol_1_5= 'mins' ) )
            {
            // InternalSparrow.g:1531:4: ( (lv_symbol_1_1= 'years' | lv_symbol_1_2= 'months' | lv_symbol_1_3= 'days' | lv_symbol_1_4= 'hours' | lv_symbol_1_5= 'mins' ) )
            // InternalSparrow.g:1532:5: (lv_symbol_1_1= 'years' | lv_symbol_1_2= 'months' | lv_symbol_1_3= 'days' | lv_symbol_1_4= 'hours' | lv_symbol_1_5= 'mins' )
            {
            // InternalSparrow.g:1532:5: (lv_symbol_1_1= 'years' | lv_symbol_1_2= 'months' | lv_symbol_1_3= 'days' | lv_symbol_1_4= 'hours' | lv_symbol_1_5= 'mins' )
            int alt29=5;
            switch ( input.LA(1) ) {
            case 57:
                {
                alt29=1;
                }
                break;
            case 58:
                {
                alt29=2;
                }
                break;
            case 59:
                {
                alt29=3;
                }
                break;
            case 60:
                {
                alt29=4;
                }
                break;
            case 61:
                {
                alt29=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // InternalSparrow.g:1533:6: lv_symbol_1_1= 'years'
                    {
                    lv_symbol_1_1=(Token)match(input,57,FOLLOW_2); 

                    						newLeafNode(lv_symbol_1_1, grammarAccess.getDurationAccess().getSymbolYearsKeyword_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDurationRule());
                    						}
                    						setWithLastConsumed(current, "symbol", lv_symbol_1_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalSparrow.g:1544:6: lv_symbol_1_2= 'months'
                    {
                    lv_symbol_1_2=(Token)match(input,58,FOLLOW_2); 

                    						newLeafNode(lv_symbol_1_2, grammarAccess.getDurationAccess().getSymbolMonthsKeyword_1_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDurationRule());
                    						}
                    						setWithLastConsumed(current, "symbol", lv_symbol_1_2, null);
                    					

                    }
                    break;
                case 3 :
                    // InternalSparrow.g:1555:6: lv_symbol_1_3= 'days'
                    {
                    lv_symbol_1_3=(Token)match(input,59,FOLLOW_2); 

                    						newLeafNode(lv_symbol_1_3, grammarAccess.getDurationAccess().getSymbolDaysKeyword_1_0_2());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDurationRule());
                    						}
                    						setWithLastConsumed(current, "symbol", lv_symbol_1_3, null);
                    					

                    }
                    break;
                case 4 :
                    // InternalSparrow.g:1566:6: lv_symbol_1_4= 'hours'
                    {
                    lv_symbol_1_4=(Token)match(input,60,FOLLOW_2); 

                    						newLeafNode(lv_symbol_1_4, grammarAccess.getDurationAccess().getSymbolHoursKeyword_1_0_3());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDurationRule());
                    						}
                    						setWithLastConsumed(current, "symbol", lv_symbol_1_4, null);
                    					

                    }
                    break;
                case 5 :
                    // InternalSparrow.g:1577:6: lv_symbol_1_5= 'mins'
                    {
                    lv_symbol_1_5=(Token)match(input,61,FOLLOW_2); 

                    						newLeafNode(lv_symbol_1_5, grammarAccess.getDurationAccess().getSymbolMinsKeyword_1_0_4());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getDurationRule());
                    						}
                    						setWithLastConsumed(current, "symbol", lv_symbol_1_5, null);
                    					

                    }
                    break;

            }


            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDuration"


    // $ANTLR start "entryRuleNow"
    // InternalSparrow.g:1594:1: entryRuleNow returns [EObject current=null] : iv_ruleNow= ruleNow EOF ;
    public final EObject entryRuleNow() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNow = null;


        try {
            // InternalSparrow.g:1594:44: (iv_ruleNow= ruleNow EOF )
            // InternalSparrow.g:1595:2: iv_ruleNow= ruleNow EOF
            {
             newCompositeNode(grammarAccess.getNowRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleNow=ruleNow();

            state._fsp--;

             current =iv_ruleNow; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNow"


    // $ANTLR start "ruleNow"
    // InternalSparrow.g:1601:1: ruleNow returns [EObject current=null] : ( (lv_value_0_0= 'now' ) ) ;
    public final EObject ruleNow() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalSparrow.g:1607:2: ( ( (lv_value_0_0= 'now' ) ) )
            // InternalSparrow.g:1608:2: ( (lv_value_0_0= 'now' ) )
            {
            // InternalSparrow.g:1608:2: ( (lv_value_0_0= 'now' ) )
            // InternalSparrow.g:1609:3: (lv_value_0_0= 'now' )
            {
            // InternalSparrow.g:1609:3: (lv_value_0_0= 'now' )
            // InternalSparrow.g:1610:4: lv_value_0_0= 'now'
            {
            lv_value_0_0=(Token)match(input,62,FOLLOW_2); 

            				newLeafNode(lv_value_0_0, grammarAccess.getNowAccess().getValueNowKeyword_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getNowRule());
            				}
            				setWithLastConsumed(current, "value", lv_value_0_0, "now");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNow"


    // $ANTLR start "entryRuleThisString"
    // InternalSparrow.g:1625:1: entryRuleThisString returns [EObject current=null] : iv_ruleThisString= ruleThisString EOF ;
    public final EObject entryRuleThisString() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleThisString = null;


        try {
            // InternalSparrow.g:1625:51: (iv_ruleThisString= ruleThisString EOF )
            // InternalSparrow.g:1626:2: iv_ruleThisString= ruleThisString EOF
            {
             newCompositeNode(grammarAccess.getThisStringRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleThisString=ruleThisString();

            state._fsp--;

             current =iv_ruleThisString; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleThisString"


    // $ANTLR start "ruleThisString"
    // InternalSparrow.g:1632:1: ruleThisString returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleThisString() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalSparrow.g:1638:2: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // InternalSparrow.g:1639:2: ( (lv_value_0_0= RULE_STRING ) )
            {
            // InternalSparrow.g:1639:2: ( (lv_value_0_0= RULE_STRING ) )
            // InternalSparrow.g:1640:3: (lv_value_0_0= RULE_STRING )
            {
            // InternalSparrow.g:1640:3: (lv_value_0_0= RULE_STRING )
            // InternalSparrow.g:1641:4: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            				newLeafNode(lv_value_0_0, grammarAccess.getThisStringAccess().getValueSTRINGTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getThisStringRule());
            				}
            				setWithLastConsumed(
            					current,
            					"value",
            					lv_value_0_0,
            					"org.eclipse.xtext.common.Terminals.STRING");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleThisString"


    // $ANTLR start "entryRuleAddress"
    // InternalSparrow.g:1660:1: entryRuleAddress returns [EObject current=null] : iv_ruleAddress= ruleAddress EOF ;
    public final EObject entryRuleAddress() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAddress = null;


        try {
            // InternalSparrow.g:1660:48: (iv_ruleAddress= ruleAddress EOF )
            // InternalSparrow.g:1661:2: iv_ruleAddress= ruleAddress EOF
            {
             newCompositeNode(grammarAccess.getAddressRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAddress=ruleAddress();

            state._fsp--;

             current =iv_ruleAddress; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAddress"


    // $ANTLR start "ruleAddress"
    // InternalSparrow.g:1667:1: ruleAddress returns [EObject current=null] : (otherlv_0= 'a' ( (lv_value_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleAddress() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalSparrow.g:1673:2: ( (otherlv_0= 'a' ( (lv_value_1_0= RULE_STRING ) ) ) )
            // InternalSparrow.g:1674:2: (otherlv_0= 'a' ( (lv_value_1_0= RULE_STRING ) ) )
            {
            // InternalSparrow.g:1674:2: (otherlv_0= 'a' ( (lv_value_1_0= RULE_STRING ) ) )
            // InternalSparrow.g:1675:3: otherlv_0= 'a' ( (lv_value_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,63,FOLLOW_29); 

            			newLeafNode(otherlv_0, grammarAccess.getAddressAccess().getAKeyword_0());
            		
            // InternalSparrow.g:1679:3: ( (lv_value_1_0= RULE_STRING ) )
            // InternalSparrow.g:1680:4: (lv_value_1_0= RULE_STRING )
            {
            // InternalSparrow.g:1680:4: (lv_value_1_0= RULE_STRING )
            // InternalSparrow.g:1681:5: lv_value_1_0= RULE_STRING
            {
            lv_value_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_value_1_0, grammarAccess.getAddressAccess().getValueSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAddressRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAddress"


    // $ANTLR start "entryRuleAllNumber"
    // InternalSparrow.g:1701:1: entryRuleAllNumber returns [EObject current=null] : iv_ruleAllNumber= ruleAllNumber EOF ;
    public final EObject entryRuleAllNumber() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAllNumber = null;


        try {
            // InternalSparrow.g:1701:50: (iv_ruleAllNumber= ruleAllNumber EOF )
            // InternalSparrow.g:1702:2: iv_ruleAllNumber= ruleAllNumber EOF
            {
             newCompositeNode(grammarAccess.getAllNumberRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAllNumber=ruleAllNumber();

            state._fsp--;

             current =iv_ruleAllNumber; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAllNumber"


    // $ANTLR start "ruleAllNumber"
    // InternalSparrow.g:1708:1: ruleAllNumber returns [EObject current=null] : ( (lv_number_0_0= RULE_INT ) ) ;
    public final EObject ruleAllNumber() throws RecognitionException {
        EObject current = null;

        Token lv_number_0_0=null;


        	enterRule();

        try {
            // InternalSparrow.g:1714:2: ( ( (lv_number_0_0= RULE_INT ) ) )
            // InternalSparrow.g:1715:2: ( (lv_number_0_0= RULE_INT ) )
            {
            // InternalSparrow.g:1715:2: ( (lv_number_0_0= RULE_INT ) )
            // InternalSparrow.g:1716:3: (lv_number_0_0= RULE_INT )
            {
            // InternalSparrow.g:1716:3: (lv_number_0_0= RULE_INT )
            // InternalSparrow.g:1717:4: lv_number_0_0= RULE_INT
            {
            lv_number_0_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            				newLeafNode(lv_number_0_0, grammarAccess.getAllNumberAccess().getNumberINTTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getAllNumberRule());
            				}
            				setWithLastConsumed(
            					current,
            					"number",
            					lv_number_0_0,
            					"org.eclipse.xtext.common.Terminals.INT");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAllNumber"


    // $ANTLR start "entryRuleThisDecimal"
    // InternalSparrow.g:1736:1: entryRuleThisDecimal returns [EObject current=null] : iv_ruleThisDecimal= ruleThisDecimal EOF ;
    public final EObject entryRuleThisDecimal() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleThisDecimal = null;


        try {
            // InternalSparrow.g:1736:52: (iv_ruleThisDecimal= ruleThisDecimal EOF )
            // InternalSparrow.g:1737:2: iv_ruleThisDecimal= ruleThisDecimal EOF
            {
             newCompositeNode(grammarAccess.getThisDecimalRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleThisDecimal=ruleThisDecimal();

            state._fsp--;

             current =iv_ruleThisDecimal; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleThisDecimal"


    // $ANTLR start "ruleThisDecimal"
    // InternalSparrow.g:1743:1: ruleThisDecimal returns [EObject current=null] : ( (lv_value_0_0= RULE_DECIMAL ) ) ;
    public final EObject ruleThisDecimal() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalSparrow.g:1749:2: ( ( (lv_value_0_0= RULE_DECIMAL ) ) )
            // InternalSparrow.g:1750:2: ( (lv_value_0_0= RULE_DECIMAL ) )
            {
            // InternalSparrow.g:1750:2: ( (lv_value_0_0= RULE_DECIMAL ) )
            // InternalSparrow.g:1751:3: (lv_value_0_0= RULE_DECIMAL )
            {
            // InternalSparrow.g:1751:3: (lv_value_0_0= RULE_DECIMAL )
            // InternalSparrow.g:1752:4: lv_value_0_0= RULE_DECIMAL
            {
            lv_value_0_0=(Token)match(input,RULE_DECIMAL,FOLLOW_2); 

            				newLeafNode(lv_value_0_0, grammarAccess.getThisDecimalAccess().getValueDECIMALTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getThisDecimalRule());
            				}
            				setWithLastConsumed(
            					current,
            					"value",
            					lv_value_0_0,
            					"org.xtext.example.mydsl.Sparrow.DECIMAL");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleThisDecimal"


    // $ANTLR start "entryRuleurl"
    // InternalSparrow.g:1771:1: entryRuleurl returns [EObject current=null] : iv_ruleurl= ruleurl EOF ;
    public final EObject entryRuleurl() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleurl = null;


        try {
            // InternalSparrow.g:1771:44: (iv_ruleurl= ruleurl EOF )
            // InternalSparrow.g:1772:2: iv_ruleurl= ruleurl EOF
            {
             newCompositeNode(grammarAccess.getUrlRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleurl=ruleurl();

            state._fsp--;

             current =iv_ruleurl; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleurl"


    // $ANTLR start "ruleurl"
    // InternalSparrow.g:1778:1: ruleurl returns [EObject current=null] : ( (lv_value_0_0= RULE_URL_STRING ) ) ;
    public final EObject ruleurl() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalSparrow.g:1784:2: ( ( (lv_value_0_0= RULE_URL_STRING ) ) )
            // InternalSparrow.g:1785:2: ( (lv_value_0_0= RULE_URL_STRING ) )
            {
            // InternalSparrow.g:1785:2: ( (lv_value_0_0= RULE_URL_STRING ) )
            // InternalSparrow.g:1786:3: (lv_value_0_0= RULE_URL_STRING )
            {
            // InternalSparrow.g:1786:3: (lv_value_0_0= RULE_URL_STRING )
            // InternalSparrow.g:1787:4: lv_value_0_0= RULE_URL_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_URL_STRING,FOLLOW_2); 

            				newLeafNode(lv_value_0_0, grammarAccess.getUrlAccess().getValueURL_STRINGTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getUrlRule());
            				}
            				setWithLastConsumed(
            					current,
            					"value",
            					lv_value_0_0,
            					"org.xtext.example.mydsl.Sparrow.URL_STRING");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleurl"


    // $ANTLR start "entryRuleThisBoolean"
    // InternalSparrow.g:1806:1: entryRuleThisBoolean returns [EObject current=null] : iv_ruleThisBoolean= ruleThisBoolean EOF ;
    public final EObject entryRuleThisBoolean() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleThisBoolean = null;


        try {
            // InternalSparrow.g:1806:52: (iv_ruleThisBoolean= ruleThisBoolean EOF )
            // InternalSparrow.g:1807:2: iv_ruleThisBoolean= ruleThisBoolean EOF
            {
             newCompositeNode(grammarAccess.getThisBooleanRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleThisBoolean=ruleThisBoolean();

            state._fsp--;

             current =iv_ruleThisBoolean; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleThisBoolean"


    // $ANTLR start "ruleThisBoolean"
    // InternalSparrow.g:1813:1: ruleThisBoolean returns [EObject current=null] : ( (lv_value_0_0= ruleBOOLEAN ) ) ;
    public final EObject ruleThisBoolean() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalSparrow.g:1819:2: ( ( (lv_value_0_0= ruleBOOLEAN ) ) )
            // InternalSparrow.g:1820:2: ( (lv_value_0_0= ruleBOOLEAN ) )
            {
            // InternalSparrow.g:1820:2: ( (lv_value_0_0= ruleBOOLEAN ) )
            // InternalSparrow.g:1821:3: (lv_value_0_0= ruleBOOLEAN )
            {
            // InternalSparrow.g:1821:3: (lv_value_0_0= ruleBOOLEAN )
            // InternalSparrow.g:1822:4: lv_value_0_0= ruleBOOLEAN
            {

            				newCompositeNode(grammarAccess.getThisBooleanAccess().getValueBOOLEANParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleBOOLEAN();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getThisBooleanRule());
            				}
            				set(
            					current,
            					"value",
            					lv_value_0_0,
            					"org.xtext.example.mydsl.Sparrow.BOOLEAN");
            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleThisBoolean"


    // $ANTLR start "entryRuleThisDate"
    // InternalSparrow.g:1842:1: entryRuleThisDate returns [EObject current=null] : iv_ruleThisDate= ruleThisDate EOF ;
    public final EObject entryRuleThisDate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleThisDate = null;


        try {
            // InternalSparrow.g:1842:49: (iv_ruleThisDate= ruleThisDate EOF )
            // InternalSparrow.g:1843:2: iv_ruleThisDate= ruleThisDate EOF
            {
             newCompositeNode(grammarAccess.getThisDateRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleThisDate=ruleThisDate();

            state._fsp--;

             current =iv_ruleThisDate; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleThisDate"


    // $ANTLR start "ruleThisDate"
    // InternalSparrow.g:1849:1: ruleThisDate returns [EObject current=null] : ( (lv_value_0_0= ruleDATE ) ) ;
    public final EObject ruleThisDate() throws RecognitionException {
        EObject current = null;

        EObject lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalSparrow.g:1855:2: ( ( (lv_value_0_0= ruleDATE ) ) )
            // InternalSparrow.g:1856:2: ( (lv_value_0_0= ruleDATE ) )
            {
            // InternalSparrow.g:1856:2: ( (lv_value_0_0= ruleDATE ) )
            // InternalSparrow.g:1857:3: (lv_value_0_0= ruleDATE )
            {
            // InternalSparrow.g:1857:3: (lv_value_0_0= ruleDATE )
            // InternalSparrow.g:1858:4: lv_value_0_0= ruleDATE
            {

            				newCompositeNode(grammarAccess.getThisDateAccess().getValueDATEParserRuleCall_0());
            			
            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleDATE();

            state._fsp--;


            				if (current==null) {
            					current = createModelElementForParent(grammarAccess.getThisDateRule());
            				}
            				set(
            					current,
            					"value",
            					lv_value_0_0,
            					"org.xtext.example.mydsl.Sparrow.DATE");
            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleThisDate"


    // $ANTLR start "entryRuleRight"
    // InternalSparrow.g:1878:1: entryRuleRight returns [EObject current=null] : iv_ruleRight= ruleRight EOF ;
    public final EObject entryRuleRight() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRight = null;


        try {
            // InternalSparrow.g:1878:46: (iv_ruleRight= ruleRight EOF )
            // InternalSparrow.g:1879:2: iv_ruleRight= ruleRight EOF
            {
             newCompositeNode(grammarAccess.getRightRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRight=ruleRight();

            state._fsp--;

             current =iv_ruleRight; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRight"


    // $ANTLR start "ruleRight"
    // InternalSparrow.g:1885:1: ruleRight returns [EObject current=null] : ( (otherlv_0= RULE_ID ) ) ;
    public final EObject ruleRight() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;


        	enterRule();

        try {
            // InternalSparrow.g:1891:2: ( ( (otherlv_0= RULE_ID ) ) )
            // InternalSparrow.g:1892:2: ( (otherlv_0= RULE_ID ) )
            {
            // InternalSparrow.g:1892:2: ( (otherlv_0= RULE_ID ) )
            // InternalSparrow.g:1893:3: (otherlv_0= RULE_ID )
            {
            // InternalSparrow.g:1893:3: (otherlv_0= RULE_ID )
            // InternalSparrow.g:1894:4: otherlv_0= RULE_ID
            {

            				if (current==null) {
            					current = createModelElement(grammarAccess.getRightRule());
            				}
            			
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(otherlv_0, grammarAccess.getRightAccess().getRightInitExpressionsCrossReference_0());
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRight"


    // $ANTLR start "entryRuleDATE"
    // InternalSparrow.g:1908:1: entryRuleDATE returns [EObject current=null] : iv_ruleDATE= ruleDATE EOF ;
    public final EObject entryRuleDATE() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDATE = null;


        try {
            // InternalSparrow.g:1908:45: (iv_ruleDATE= ruleDATE EOF )
            // InternalSparrow.g:1909:2: iv_ruleDATE= ruleDATE EOF
            {
             newCompositeNode(grammarAccess.getDATERule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDATE=ruleDATE();

            state._fsp--;

             current =iv_ruleDATE; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDATE"


    // $ANTLR start "ruleDATE"
    // InternalSparrow.g:1915:1: ruleDATE returns [EObject current=null] : ( ( (lv_year_0_0= RULE_INT ) ) otherlv_1= '/' ( (lv_month_2_0= RULE_INT ) ) otherlv_3= '/' ( (lv_day_4_0= RULE_INT ) ) otherlv_5= ',' ( (lv_hour_6_0= RULE_INT ) ) otherlv_7= ':' ( (lv_min_8_0= RULE_INT ) ) ) ;
    public final EObject ruleDATE() throws RecognitionException {
        EObject current = null;

        Token lv_year_0_0=null;
        Token otherlv_1=null;
        Token lv_month_2_0=null;
        Token otherlv_3=null;
        Token lv_day_4_0=null;
        Token otherlv_5=null;
        Token lv_hour_6_0=null;
        Token otherlv_7=null;
        Token lv_min_8_0=null;


        	enterRule();

        try {
            // InternalSparrow.g:1921:2: ( ( ( (lv_year_0_0= RULE_INT ) ) otherlv_1= '/' ( (lv_month_2_0= RULE_INT ) ) otherlv_3= '/' ( (lv_day_4_0= RULE_INT ) ) otherlv_5= ',' ( (lv_hour_6_0= RULE_INT ) ) otherlv_7= ':' ( (lv_min_8_0= RULE_INT ) ) ) )
            // InternalSparrow.g:1922:2: ( ( (lv_year_0_0= RULE_INT ) ) otherlv_1= '/' ( (lv_month_2_0= RULE_INT ) ) otherlv_3= '/' ( (lv_day_4_0= RULE_INT ) ) otherlv_5= ',' ( (lv_hour_6_0= RULE_INT ) ) otherlv_7= ':' ( (lv_min_8_0= RULE_INT ) ) )
            {
            // InternalSparrow.g:1922:2: ( ( (lv_year_0_0= RULE_INT ) ) otherlv_1= '/' ( (lv_month_2_0= RULE_INT ) ) otherlv_3= '/' ( (lv_day_4_0= RULE_INT ) ) otherlv_5= ',' ( (lv_hour_6_0= RULE_INT ) ) otherlv_7= ':' ( (lv_min_8_0= RULE_INT ) ) )
            // InternalSparrow.g:1923:3: ( (lv_year_0_0= RULE_INT ) ) otherlv_1= '/' ( (lv_month_2_0= RULE_INT ) ) otherlv_3= '/' ( (lv_day_4_0= RULE_INT ) ) otherlv_5= ',' ( (lv_hour_6_0= RULE_INT ) ) otherlv_7= ':' ( (lv_min_8_0= RULE_INT ) )
            {
            // InternalSparrow.g:1923:3: ( (lv_year_0_0= RULE_INT ) )
            // InternalSparrow.g:1924:4: (lv_year_0_0= RULE_INT )
            {
            // InternalSparrow.g:1924:4: (lv_year_0_0= RULE_INT )
            // InternalSparrow.g:1925:5: lv_year_0_0= RULE_INT
            {
            lv_year_0_0=(Token)match(input,RULE_INT,FOLLOW_30); 

            					newLeafNode(lv_year_0_0, grammarAccess.getDATEAccess().getYearINTTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDATERule());
            					}
            					setWithLastConsumed(
            						current,
            						"year",
            						lv_year_0_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_1=(Token)match(input,64,FOLLOW_31); 

            			newLeafNode(otherlv_1, grammarAccess.getDATEAccess().getSolidusKeyword_1());
            		
            // InternalSparrow.g:1945:3: ( (lv_month_2_0= RULE_INT ) )
            // InternalSparrow.g:1946:4: (lv_month_2_0= RULE_INT )
            {
            // InternalSparrow.g:1946:4: (lv_month_2_0= RULE_INT )
            // InternalSparrow.g:1947:5: lv_month_2_0= RULE_INT
            {
            lv_month_2_0=(Token)match(input,RULE_INT,FOLLOW_30); 

            					newLeafNode(lv_month_2_0, grammarAccess.getDATEAccess().getMonthINTTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDATERule());
            					}
            					setWithLastConsumed(
            						current,
            						"month",
            						lv_month_2_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_3=(Token)match(input,64,FOLLOW_31); 

            			newLeafNode(otherlv_3, grammarAccess.getDATEAccess().getSolidusKeyword_3());
            		
            // InternalSparrow.g:1967:3: ( (lv_day_4_0= RULE_INT ) )
            // InternalSparrow.g:1968:4: (lv_day_4_0= RULE_INT )
            {
            // InternalSparrow.g:1968:4: (lv_day_4_0= RULE_INT )
            // InternalSparrow.g:1969:5: lv_day_4_0= RULE_INT
            {
            lv_day_4_0=(Token)match(input,RULE_INT,FOLLOW_32); 

            					newLeafNode(lv_day_4_0, grammarAccess.getDATEAccess().getDayINTTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDATERule());
            					}
            					setWithLastConsumed(
            						current,
            						"day",
            						lv_day_4_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_5=(Token)match(input,22,FOLLOW_31); 

            			newLeafNode(otherlv_5, grammarAccess.getDATEAccess().getCommaKeyword_5());
            		
            // InternalSparrow.g:1989:3: ( (lv_hour_6_0= RULE_INT ) )
            // InternalSparrow.g:1990:4: (lv_hour_6_0= RULE_INT )
            {
            // InternalSparrow.g:1990:4: (lv_hour_6_0= RULE_INT )
            // InternalSparrow.g:1991:5: lv_hour_6_0= RULE_INT
            {
            lv_hour_6_0=(Token)match(input,RULE_INT,FOLLOW_16); 

            					newLeafNode(lv_hour_6_0, grammarAccess.getDATEAccess().getHourINTTerminalRuleCall_6_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDATERule());
            					}
            					setWithLastConsumed(
            						current,
            						"hour",
            						lv_hour_6_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_7=(Token)match(input,21,FOLLOW_31); 

            			newLeafNode(otherlv_7, grammarAccess.getDATEAccess().getColonKeyword_7());
            		
            // InternalSparrow.g:2011:3: ( (lv_min_8_0= RULE_INT ) )
            // InternalSparrow.g:2012:4: (lv_min_8_0= RULE_INT )
            {
            // InternalSparrow.g:2012:4: (lv_min_8_0= RULE_INT )
            // InternalSparrow.g:2013:5: lv_min_8_0= RULE_INT
            {
            lv_min_8_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            					newLeafNode(lv_min_8_0, grammarAccess.getDATEAccess().getMinINTTerminalRuleCall_8_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDATERule());
            					}
            					setWithLastConsumed(
            						current,
            						"min",
            						lv_min_8_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDATE"


    // $ANTLR start "entryRuleObject"
    // InternalSparrow.g:2033:1: entryRuleObject returns [EObject current=null] : iv_ruleObject= ruleObject EOF ;
    public final EObject entryRuleObject() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObject = null;


        try {
            // InternalSparrow.g:2033:47: (iv_ruleObject= ruleObject EOF )
            // InternalSparrow.g:2034:2: iv_ruleObject= ruleObject EOF
            {
             newCompositeNode(grammarAccess.getObjectRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleObject=ruleObject();

            state._fsp--;

             current =iv_ruleObject; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleObject"


    // $ANTLR start "ruleObject"
    // InternalSparrow.g:2040:1: ruleObject returns [EObject current=null] : (otherlv_0= 'Token' ( (lv_name_1_0= RULE_ID ) ) ( (lv_objectExpression_2_0= ruleObjectExpression ) ) ) ;
    public final EObject ruleObject() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        EObject lv_objectExpression_2_0 = null;



        	enterRule();

        try {
            // InternalSparrow.g:2046:2: ( (otherlv_0= 'Token' ( (lv_name_1_0= RULE_ID ) ) ( (lv_objectExpression_2_0= ruleObjectExpression ) ) ) )
            // InternalSparrow.g:2047:2: (otherlv_0= 'Token' ( (lv_name_1_0= RULE_ID ) ) ( (lv_objectExpression_2_0= ruleObjectExpression ) ) )
            {
            // InternalSparrow.g:2047:2: (otherlv_0= 'Token' ( (lv_name_1_0= RULE_ID ) ) ( (lv_objectExpression_2_0= ruleObjectExpression ) ) )
            // InternalSparrow.g:2048:3: otherlv_0= 'Token' ( (lv_name_1_0= RULE_ID ) ) ( (lv_objectExpression_2_0= ruleObjectExpression ) )
            {
            otherlv_0=(Token)match(input,65,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getObjectAccess().getTokenKeyword_0());
            		
            // InternalSparrow.g:2052:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSparrow.g:2053:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSparrow.g:2053:4: (lv_name_1_0= RULE_ID )
            // InternalSparrow.g:2054:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_6); 

            					newLeafNode(lv_name_1_0, grammarAccess.getObjectAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getObjectRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalSparrow.g:2070:3: ( (lv_objectExpression_2_0= ruleObjectExpression ) )
            // InternalSparrow.g:2071:4: (lv_objectExpression_2_0= ruleObjectExpression )
            {
            // InternalSparrow.g:2071:4: (lv_objectExpression_2_0= ruleObjectExpression )
            // InternalSparrow.g:2072:5: lv_objectExpression_2_0= ruleObjectExpression
            {

            					newCompositeNode(grammarAccess.getObjectAccess().getObjectExpressionObjectExpressionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_objectExpression_2_0=ruleObjectExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getObjectRule());
            					}
            					set(
            						current,
            						"objectExpression",
            						lv_objectExpression_2_0,
            						"org.xtext.example.mydsl.Sparrow.ObjectExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleObject"


    // $ANTLR start "entryRuleObjectExpression"
    // InternalSparrow.g:2093:1: entryRuleObjectExpression returns [EObject current=null] : iv_ruleObjectExpression= ruleObjectExpression EOF ;
    public final EObject entryRuleObjectExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectExpression = null;


        try {
            // InternalSparrow.g:2093:57: (iv_ruleObjectExpression= ruleObjectExpression EOF )
            // InternalSparrow.g:2094:2: iv_ruleObjectExpression= ruleObjectExpression EOF
            {
             newCompositeNode(grammarAccess.getObjectExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleObjectExpression=ruleObjectExpression();

            state._fsp--;

             current =iv_ruleObjectExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleObjectExpression"


    // $ANTLR start "ruleObjectExpression"
    // InternalSparrow.g:2100:1: ruleObjectExpression returns [EObject current=null] : (otherlv_0= '{' ( (lv_keyValue_1_0= rulekeyvalue ) ) (otherlv_2= ',' ( (lv_keyValue_3_0= rulekeyvalue ) ) )* otherlv_4= '}' ) ;
    public final EObject ruleObjectExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_keyValue_1_0 = null;

        EObject lv_keyValue_3_0 = null;



        	enterRule();

        try {
            // InternalSparrow.g:2106:2: ( (otherlv_0= '{' ( (lv_keyValue_1_0= rulekeyvalue ) ) (otherlv_2= ',' ( (lv_keyValue_3_0= rulekeyvalue ) ) )* otherlv_4= '}' ) )
            // InternalSparrow.g:2107:2: (otherlv_0= '{' ( (lv_keyValue_1_0= rulekeyvalue ) ) (otherlv_2= ',' ( (lv_keyValue_3_0= rulekeyvalue ) ) )* otherlv_4= '}' )
            {
            // InternalSparrow.g:2107:2: (otherlv_0= '{' ( (lv_keyValue_1_0= rulekeyvalue ) ) (otherlv_2= ',' ( (lv_keyValue_3_0= rulekeyvalue ) ) )* otherlv_4= '}' )
            // InternalSparrow.g:2108:3: otherlv_0= '{' ( (lv_keyValue_1_0= rulekeyvalue ) ) (otherlv_2= ',' ( (lv_keyValue_3_0= rulekeyvalue ) ) )* otherlv_4= '}'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_27); 

            			newLeafNode(otherlv_0, grammarAccess.getObjectExpressionAccess().getLeftCurlyBracketKeyword_0());
            		
            // InternalSparrow.g:2112:3: ( (lv_keyValue_1_0= rulekeyvalue ) )
            // InternalSparrow.g:2113:4: (lv_keyValue_1_0= rulekeyvalue )
            {
            // InternalSparrow.g:2113:4: (lv_keyValue_1_0= rulekeyvalue )
            // InternalSparrow.g:2114:5: lv_keyValue_1_0= rulekeyvalue
            {

            					newCompositeNode(grammarAccess.getObjectExpressionAccess().getKeyValueKeyvalueParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_25);
            lv_keyValue_1_0=rulekeyvalue();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getObjectExpressionRule());
            					}
            					add(
            						current,
            						"keyValue",
            						lv_keyValue_1_0,
            						"org.xtext.example.mydsl.Sparrow.keyvalue");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSparrow.g:2131:3: (otherlv_2= ',' ( (lv_keyValue_3_0= rulekeyvalue ) ) )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==22) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // InternalSparrow.g:2132:4: otherlv_2= ',' ( (lv_keyValue_3_0= rulekeyvalue ) )
            	    {
            	    otherlv_2=(Token)match(input,22,FOLLOW_27); 

            	    				newLeafNode(otherlv_2, grammarAccess.getObjectExpressionAccess().getCommaKeyword_2_0());
            	    			
            	    // InternalSparrow.g:2136:4: ( (lv_keyValue_3_0= rulekeyvalue ) )
            	    // InternalSparrow.g:2137:5: (lv_keyValue_3_0= rulekeyvalue )
            	    {
            	    // InternalSparrow.g:2137:5: (lv_keyValue_3_0= rulekeyvalue )
            	    // InternalSparrow.g:2138:6: lv_keyValue_3_0= rulekeyvalue
            	    {

            	    						newCompositeNode(grammarAccess.getObjectExpressionAccess().getKeyValueKeyvalueParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_25);
            	    lv_keyValue_3_0=rulekeyvalue();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getObjectExpressionRule());
            	    						}
            	    						add(
            	    							current,
            	    							"keyValue",
            	    							lv_keyValue_3_0,
            	    							"org.xtext.example.mydsl.Sparrow.keyvalue");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

            otherlv_4=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getObjectExpressionAccess().getRightCurlyBracketKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleObjectExpression"


    // $ANTLR start "entryRuleCondition"
    // InternalSparrow.g:2164:1: entryRuleCondition returns [EObject current=null] : iv_ruleCondition= ruleCondition EOF ;
    public final EObject entryRuleCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCondition = null;


        try {
            // InternalSparrow.g:2164:50: (iv_ruleCondition= ruleCondition EOF )
            // InternalSparrow.g:2165:2: iv_ruleCondition= ruleCondition EOF
            {
             newCompositeNode(grammarAccess.getConditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCondition=ruleCondition();

            state._fsp--;

             current =iv_ruleCondition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCondition"


    // $ANTLR start "ruleCondition"
    // InternalSparrow.g:2171:1: ruleCondition returns [EObject current=null] : (otherlv_0= 'Conditions' otherlv_1= '[' ( (lv_conditions_2_0= ruleConditionLink ) ) (otherlv_3= ',' ( (lv_conditions_4_0= ruleConditionLink ) ) )* otherlv_5= ']' ) ;
    public final EObject ruleCondition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_conditions_2_0 = null;

        EObject lv_conditions_4_0 = null;



        	enterRule();

        try {
            // InternalSparrow.g:2177:2: ( (otherlv_0= 'Conditions' otherlv_1= '[' ( (lv_conditions_2_0= ruleConditionLink ) ) (otherlv_3= ',' ( (lv_conditions_4_0= ruleConditionLink ) ) )* otherlv_5= ']' ) )
            // InternalSparrow.g:2178:2: (otherlv_0= 'Conditions' otherlv_1= '[' ( (lv_conditions_2_0= ruleConditionLink ) ) (otherlv_3= ',' ( (lv_conditions_4_0= ruleConditionLink ) ) )* otherlv_5= ']' )
            {
            // InternalSparrow.g:2178:2: (otherlv_0= 'Conditions' otherlv_1= '[' ( (lv_conditions_2_0= ruleConditionLink ) ) (otherlv_3= ',' ( (lv_conditions_4_0= ruleConditionLink ) ) )* otherlv_5= ']' )
            // InternalSparrow.g:2179:3: otherlv_0= 'Conditions' otherlv_1= '[' ( (lv_conditions_2_0= ruleConditionLink ) ) (otherlv_3= ',' ( (lv_conditions_4_0= ruleConditionLink ) ) )* otherlv_5= ']'
            {
            otherlv_0=(Token)match(input,66,FOLLOW_33); 

            			newLeafNode(otherlv_0, grammarAccess.getConditionAccess().getConditionsKeyword_0());
            		
            otherlv_1=(Token)match(input,67,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getConditionAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalSparrow.g:2187:3: ( (lv_conditions_2_0= ruleConditionLink ) )
            // InternalSparrow.g:2188:4: (lv_conditions_2_0= ruleConditionLink )
            {
            // InternalSparrow.g:2188:4: (lv_conditions_2_0= ruleConditionLink )
            // InternalSparrow.g:2189:5: lv_conditions_2_0= ruleConditionLink
            {

            					newCompositeNode(grammarAccess.getConditionAccess().getConditionsConditionLinkParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_34);
            lv_conditions_2_0=ruleConditionLink();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConditionRule());
            					}
            					add(
            						current,
            						"conditions",
            						lv_conditions_2_0,
            						"org.xtext.example.mydsl.Sparrow.ConditionLink");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSparrow.g:2206:3: (otherlv_3= ',' ( (lv_conditions_4_0= ruleConditionLink ) ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==22) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalSparrow.g:2207:4: otherlv_3= ',' ( (lv_conditions_4_0= ruleConditionLink ) )
            	    {
            	    otherlv_3=(Token)match(input,22,FOLLOW_3); 

            	    				newLeafNode(otherlv_3, grammarAccess.getConditionAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalSparrow.g:2211:4: ( (lv_conditions_4_0= ruleConditionLink ) )
            	    // InternalSparrow.g:2212:5: (lv_conditions_4_0= ruleConditionLink )
            	    {
            	    // InternalSparrow.g:2212:5: (lv_conditions_4_0= ruleConditionLink )
            	    // InternalSparrow.g:2213:6: lv_conditions_4_0= ruleConditionLink
            	    {

            	    						newCompositeNode(grammarAccess.getConditionAccess().getConditionsConditionLinkParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_34);
            	    lv_conditions_4_0=ruleConditionLink();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getConditionRule());
            	    						}
            	    						add(
            	    							current,
            	    							"conditions",
            	    							lv_conditions_4_0,
            	    							"org.xtext.example.mydsl.Sparrow.ConditionLink");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);

            otherlv_5=(Token)match(input,68,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getConditionAccess().getRightSquareBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCondition"


    // $ANTLR start "entryRuleConditionLink"
    // InternalSparrow.g:2239:1: entryRuleConditionLink returns [EObject current=null] : iv_ruleConditionLink= ruleConditionLink EOF ;
    public final EObject entryRuleConditionLink() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConditionLink = null;


        try {
            // InternalSparrow.g:2239:54: (iv_ruleConditionLink= ruleConditionLink EOF )
            // InternalSparrow.g:2240:2: iv_ruleConditionLink= ruleConditionLink EOF
            {
             newCompositeNode(grammarAccess.getConditionLinkRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConditionLink=ruleConditionLink();

            state._fsp--;

             current =iv_ruleConditionLink; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConditionLink"


    // $ANTLR start "ruleConditionLink"
    // InternalSparrow.g:2246:1: ruleConditionLink returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_conditionExpression_2_0= ruleSingleCondition ) ) | ( (lv_linkCondition_3_0= ruleSingleLinkCondition ) ) )? ( (lv_andOrLink_4_0= ruleAndOrCondition ) )* ) ;
    public final EObject ruleConditionLink() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        EObject lv_conditionExpression_2_0 = null;

        EObject lv_linkCondition_3_0 = null;

        EObject lv_andOrLink_4_0 = null;



        	enterRule();

        try {
            // InternalSparrow.g:2252:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_conditionExpression_2_0= ruleSingleCondition ) ) | ( (lv_linkCondition_3_0= ruleSingleLinkCondition ) ) )? ( (lv_andOrLink_4_0= ruleAndOrCondition ) )* ) )
            // InternalSparrow.g:2253:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_conditionExpression_2_0= ruleSingleCondition ) ) | ( (lv_linkCondition_3_0= ruleSingleLinkCondition ) ) )? ( (lv_andOrLink_4_0= ruleAndOrCondition ) )* )
            {
            // InternalSparrow.g:2253:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_conditionExpression_2_0= ruleSingleCondition ) ) | ( (lv_linkCondition_3_0= ruleSingleLinkCondition ) ) )? ( (lv_andOrLink_4_0= ruleAndOrCondition ) )* )
            // InternalSparrow.g:2254:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_conditionExpression_2_0= ruleSingleCondition ) ) | ( (lv_linkCondition_3_0= ruleSingleLinkCondition ) ) )? ( (lv_andOrLink_4_0= ruleAndOrCondition ) )*
            {
            // InternalSparrow.g:2254:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalSparrow.g:2255:4: (lv_name_0_0= RULE_ID )
            {
            // InternalSparrow.g:2255:4: (lv_name_0_0= RULE_ID )
            // InternalSparrow.g:2256:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_16); 

            					newLeafNode(lv_name_0_0, grammarAccess.getConditionLinkAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConditionLinkRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,21,FOLLOW_35); 

            			newLeafNode(otherlv_1, grammarAccess.getConditionLinkAccess().getColonKeyword_1());
            		
            // InternalSparrow.g:2276:3: ( ( (lv_conditionExpression_2_0= ruleSingleCondition ) ) | ( (lv_linkCondition_3_0= ruleSingleLinkCondition ) ) )?
            int alt32=3;
            switch ( input.LA(1) ) {
                case 77:
                    {
                    int LA32_1 = input.LA(2);

                    if ( (LA32_1==85||(LA32_1>=87 && LA32_1<=89)||(LA32_1>=91 && LA32_1<=95)) ) {
                        alt32=1;
                    }
                    else if ( (LA32_1==RULE_ID) ) {
                        alt32=2;
                    }
                    }
                    break;
                case 85:
                case 87:
                case 88:
                case 89:
                case 91:
                case 92:
                case 93:
                case 94:
                case 95:
                    {
                    alt32=1;
                    }
                    break;
                case RULE_ID:
                    {
                    alt32=2;
                    }
                    break;
            }

            switch (alt32) {
                case 1 :
                    // InternalSparrow.g:2277:4: ( (lv_conditionExpression_2_0= ruleSingleCondition ) )
                    {
                    // InternalSparrow.g:2277:4: ( (lv_conditionExpression_2_0= ruleSingleCondition ) )
                    // InternalSparrow.g:2278:5: (lv_conditionExpression_2_0= ruleSingleCondition )
                    {
                    // InternalSparrow.g:2278:5: (lv_conditionExpression_2_0= ruleSingleCondition )
                    // InternalSparrow.g:2279:6: lv_conditionExpression_2_0= ruleSingleCondition
                    {

                    						newCompositeNode(grammarAccess.getConditionLinkAccess().getConditionExpressionSingleConditionParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_36);
                    lv_conditionExpression_2_0=ruleSingleCondition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getConditionLinkRule());
                    						}
                    						set(
                    							current,
                    							"conditionExpression",
                    							lv_conditionExpression_2_0,
                    							"org.xtext.example.mydsl.Sparrow.SingleCondition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSparrow.g:2297:4: ( (lv_linkCondition_3_0= ruleSingleLinkCondition ) )
                    {
                    // InternalSparrow.g:2297:4: ( (lv_linkCondition_3_0= ruleSingleLinkCondition ) )
                    // InternalSparrow.g:2298:5: (lv_linkCondition_3_0= ruleSingleLinkCondition )
                    {
                    // InternalSparrow.g:2298:5: (lv_linkCondition_3_0= ruleSingleLinkCondition )
                    // InternalSparrow.g:2299:6: lv_linkCondition_3_0= ruleSingleLinkCondition
                    {

                    						newCompositeNode(grammarAccess.getConditionLinkAccess().getLinkConditionSingleLinkConditionParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_36);
                    lv_linkCondition_3_0=ruleSingleLinkCondition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getConditionLinkRule());
                    						}
                    						set(
                    							current,
                    							"linkCondition",
                    							lv_linkCondition_3_0,
                    							"org.xtext.example.mydsl.Sparrow.SingleLinkCondition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalSparrow.g:2317:3: ( (lv_andOrLink_4_0= ruleAndOrCondition ) )*
            loop33:
            do {
                int alt33=2;
                int LA33_0 = input.LA(1);

                if ( ((LA33_0>=69 && LA33_0<=70)) ) {
                    alt33=1;
                }


                switch (alt33) {
            	case 1 :
            	    // InternalSparrow.g:2318:4: (lv_andOrLink_4_0= ruleAndOrCondition )
            	    {
            	    // InternalSparrow.g:2318:4: (lv_andOrLink_4_0= ruleAndOrCondition )
            	    // InternalSparrow.g:2319:5: lv_andOrLink_4_0= ruleAndOrCondition
            	    {

            	    					newCompositeNode(grammarAccess.getConditionLinkAccess().getAndOrLinkAndOrConditionParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_36);
            	    lv_andOrLink_4_0=ruleAndOrCondition();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getConditionLinkRule());
            	    					}
            	    					add(
            	    						current,
            	    						"andOrLink",
            	    						lv_andOrLink_4_0,
            	    						"org.xtext.example.mydsl.Sparrow.AndOrCondition");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop33;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConditionLink"


    // $ANTLR start "entryRuleAndOrCondition"
    // InternalSparrow.g:2340:1: entryRuleAndOrCondition returns [EObject current=null] : iv_ruleAndOrCondition= ruleAndOrCondition EOF ;
    public final EObject entryRuleAndOrCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndOrCondition = null;


        try {
            // InternalSparrow.g:2340:55: (iv_ruleAndOrCondition= ruleAndOrCondition EOF )
            // InternalSparrow.g:2341:2: iv_ruleAndOrCondition= ruleAndOrCondition EOF
            {
             newCompositeNode(grammarAccess.getAndOrConditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAndOrCondition=ruleAndOrCondition();

            state._fsp--;

             current =iv_ruleAndOrCondition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAndOrCondition"


    // $ANTLR start "ruleAndOrCondition"
    // InternalSparrow.g:2347:1: ruleAndOrCondition returns [EObject current=null] : ( ( ( (lv_link_0_1= 'and' | lv_link_0_2= 'or' ) ) ) ( ( (lv_condition_1_0= ruleSingleCondition ) ) | ( (lv_linkCondition_2_0= ruleSingleLinkCondition ) ) ) ) ;
    public final EObject ruleAndOrCondition() throws RecognitionException {
        EObject current = null;

        Token lv_link_0_1=null;
        Token lv_link_0_2=null;
        EObject lv_condition_1_0 = null;

        EObject lv_linkCondition_2_0 = null;



        	enterRule();

        try {
            // InternalSparrow.g:2353:2: ( ( ( ( (lv_link_0_1= 'and' | lv_link_0_2= 'or' ) ) ) ( ( (lv_condition_1_0= ruleSingleCondition ) ) | ( (lv_linkCondition_2_0= ruleSingleLinkCondition ) ) ) ) )
            // InternalSparrow.g:2354:2: ( ( ( (lv_link_0_1= 'and' | lv_link_0_2= 'or' ) ) ) ( ( (lv_condition_1_0= ruleSingleCondition ) ) | ( (lv_linkCondition_2_0= ruleSingleLinkCondition ) ) ) )
            {
            // InternalSparrow.g:2354:2: ( ( ( (lv_link_0_1= 'and' | lv_link_0_2= 'or' ) ) ) ( ( (lv_condition_1_0= ruleSingleCondition ) ) | ( (lv_linkCondition_2_0= ruleSingleLinkCondition ) ) ) )
            // InternalSparrow.g:2355:3: ( ( (lv_link_0_1= 'and' | lv_link_0_2= 'or' ) ) ) ( ( (lv_condition_1_0= ruleSingleCondition ) ) | ( (lv_linkCondition_2_0= ruleSingleLinkCondition ) ) )
            {
            // InternalSparrow.g:2355:3: ( ( (lv_link_0_1= 'and' | lv_link_0_2= 'or' ) ) )
            // InternalSparrow.g:2356:4: ( (lv_link_0_1= 'and' | lv_link_0_2= 'or' ) )
            {
            // InternalSparrow.g:2356:4: ( (lv_link_0_1= 'and' | lv_link_0_2= 'or' ) )
            // InternalSparrow.g:2357:5: (lv_link_0_1= 'and' | lv_link_0_2= 'or' )
            {
            // InternalSparrow.g:2357:5: (lv_link_0_1= 'and' | lv_link_0_2= 'or' )
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==69) ) {
                alt34=1;
            }
            else if ( (LA34_0==70) ) {
                alt34=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }
            switch (alt34) {
                case 1 :
                    // InternalSparrow.g:2358:6: lv_link_0_1= 'and'
                    {
                    lv_link_0_1=(Token)match(input,69,FOLLOW_37); 

                    						newLeafNode(lv_link_0_1, grammarAccess.getAndOrConditionAccess().getLinkAndKeyword_0_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAndOrConditionRule());
                    						}
                    						setWithLastConsumed(current, "link", lv_link_0_1, null);
                    					

                    }
                    break;
                case 2 :
                    // InternalSparrow.g:2369:6: lv_link_0_2= 'or'
                    {
                    lv_link_0_2=(Token)match(input,70,FOLLOW_37); 

                    						newLeafNode(lv_link_0_2, grammarAccess.getAndOrConditionAccess().getLinkOrKeyword_0_0_1());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAndOrConditionRule());
                    						}
                    						setWithLastConsumed(current, "link", lv_link_0_2, null);
                    					

                    }
                    break;

            }


            }


            }

            // InternalSparrow.g:2382:3: ( ( (lv_condition_1_0= ruleSingleCondition ) ) | ( (lv_linkCondition_2_0= ruleSingleLinkCondition ) ) )
            int alt35=2;
            switch ( input.LA(1) ) {
            case 77:
                {
                int LA35_1 = input.LA(2);

                if ( (LA35_1==RULE_ID) ) {
                    alt35=2;
                }
                else if ( (LA35_1==85||(LA35_1>=87 && LA35_1<=89)||(LA35_1>=91 && LA35_1<=95)) ) {
                    alt35=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 35, 1, input);

                    throw nvae;
                }
                }
                break;
            case 85:
            case 87:
            case 88:
            case 89:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
                {
                alt35=1;
                }
                break;
            case RULE_ID:
                {
                alt35=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // InternalSparrow.g:2383:4: ( (lv_condition_1_0= ruleSingleCondition ) )
                    {
                    // InternalSparrow.g:2383:4: ( (lv_condition_1_0= ruleSingleCondition ) )
                    // InternalSparrow.g:2384:5: (lv_condition_1_0= ruleSingleCondition )
                    {
                    // InternalSparrow.g:2384:5: (lv_condition_1_0= ruleSingleCondition )
                    // InternalSparrow.g:2385:6: lv_condition_1_0= ruleSingleCondition
                    {

                    						newCompositeNode(grammarAccess.getAndOrConditionAccess().getConditionSingleConditionParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_condition_1_0=ruleSingleCondition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAndOrConditionRule());
                    						}
                    						set(
                    							current,
                    							"condition",
                    							lv_condition_1_0,
                    							"org.xtext.example.mydsl.Sparrow.SingleCondition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSparrow.g:2403:4: ( (lv_linkCondition_2_0= ruleSingleLinkCondition ) )
                    {
                    // InternalSparrow.g:2403:4: ( (lv_linkCondition_2_0= ruleSingleLinkCondition ) )
                    // InternalSparrow.g:2404:5: (lv_linkCondition_2_0= ruleSingleLinkCondition )
                    {
                    // InternalSparrow.g:2404:5: (lv_linkCondition_2_0= ruleSingleLinkCondition )
                    // InternalSparrow.g:2405:6: lv_linkCondition_2_0= ruleSingleLinkCondition
                    {

                    						newCompositeNode(grammarAccess.getAndOrConditionAccess().getLinkConditionSingleLinkConditionParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_linkCondition_2_0=ruleSingleLinkCondition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAndOrConditionRule());
                    						}
                    						set(
                    							current,
                    							"linkCondition",
                    							lv_linkCondition_2_0,
                    							"org.xtext.example.mydsl.Sparrow.SingleLinkCondition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAndOrCondition"


    // $ANTLR start "entryRuleOperation"
    // InternalSparrow.g:2427:1: entryRuleOperation returns [EObject current=null] : iv_ruleOperation= ruleOperation EOF ;
    public final EObject entryRuleOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation = null;


        try {
            // InternalSparrow.g:2427:50: (iv_ruleOperation= ruleOperation EOF )
            // InternalSparrow.g:2428:2: iv_ruleOperation= ruleOperation EOF
            {
             newCompositeNode(grammarAccess.getOperationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOperation=ruleOperation();

            state._fsp--;

             current =iv_ruleOperation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOperation"


    // $ANTLR start "ruleOperation"
    // InternalSparrow.g:2434:1: ruleOperation returns [EObject current=null] : (otherlv_0= 'Operations' otherlv_1= '[' ( (lv_operates_2_0= ruleOperateLink ) ) (otherlv_3= ',' ( (lv_operates_4_0= ruleOperateLink ) ) )* otherlv_5= ']' ) ;
    public final EObject ruleOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_operates_2_0 = null;

        EObject lv_operates_4_0 = null;



        	enterRule();

        try {
            // InternalSparrow.g:2440:2: ( (otherlv_0= 'Operations' otherlv_1= '[' ( (lv_operates_2_0= ruleOperateLink ) ) (otherlv_3= ',' ( (lv_operates_4_0= ruleOperateLink ) ) )* otherlv_5= ']' ) )
            // InternalSparrow.g:2441:2: (otherlv_0= 'Operations' otherlv_1= '[' ( (lv_operates_2_0= ruleOperateLink ) ) (otherlv_3= ',' ( (lv_operates_4_0= ruleOperateLink ) ) )* otherlv_5= ']' )
            {
            // InternalSparrow.g:2441:2: (otherlv_0= 'Operations' otherlv_1= '[' ( (lv_operates_2_0= ruleOperateLink ) ) (otherlv_3= ',' ( (lv_operates_4_0= ruleOperateLink ) ) )* otherlv_5= ']' )
            // InternalSparrow.g:2442:3: otherlv_0= 'Operations' otherlv_1= '[' ( (lv_operates_2_0= ruleOperateLink ) ) (otherlv_3= ',' ( (lv_operates_4_0= ruleOperateLink ) ) )* otherlv_5= ']'
            {
            otherlv_0=(Token)match(input,71,FOLLOW_33); 

            			newLeafNode(otherlv_0, grammarAccess.getOperationAccess().getOperationsKeyword_0());
            		
            otherlv_1=(Token)match(input,67,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getOperationAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalSparrow.g:2450:3: ( (lv_operates_2_0= ruleOperateLink ) )
            // InternalSparrow.g:2451:4: (lv_operates_2_0= ruleOperateLink )
            {
            // InternalSparrow.g:2451:4: (lv_operates_2_0= ruleOperateLink )
            // InternalSparrow.g:2452:5: lv_operates_2_0= ruleOperateLink
            {

            					newCompositeNode(grammarAccess.getOperationAccess().getOperatesOperateLinkParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_34);
            lv_operates_2_0=ruleOperateLink();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOperationRule());
            					}
            					add(
            						current,
            						"operates",
            						lv_operates_2_0,
            						"org.xtext.example.mydsl.Sparrow.OperateLink");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSparrow.g:2469:3: (otherlv_3= ',' ( (lv_operates_4_0= ruleOperateLink ) ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==22) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalSparrow.g:2470:4: otherlv_3= ',' ( (lv_operates_4_0= ruleOperateLink ) )
            	    {
            	    otherlv_3=(Token)match(input,22,FOLLOW_3); 

            	    				newLeafNode(otherlv_3, grammarAccess.getOperationAccess().getCommaKeyword_3_0());
            	    			
            	    // InternalSparrow.g:2474:4: ( (lv_operates_4_0= ruleOperateLink ) )
            	    // InternalSparrow.g:2475:5: (lv_operates_4_0= ruleOperateLink )
            	    {
            	    // InternalSparrow.g:2475:5: (lv_operates_4_0= ruleOperateLink )
            	    // InternalSparrow.g:2476:6: lv_operates_4_0= ruleOperateLink
            	    {

            	    						newCompositeNode(grammarAccess.getOperationAccess().getOperatesOperateLinkParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_34);
            	    lv_operates_4_0=ruleOperateLink();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getOperationRule());
            	    						}
            	    						add(
            	    							current,
            	    							"operates",
            	    							lv_operates_4_0,
            	    							"org.xtext.example.mydsl.Sparrow.OperateLink");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop36;
                }
            } while (true);

            otherlv_5=(Token)match(input,68,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getOperationAccess().getRightSquareBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOperation"


    // $ANTLR start "entryRuleOperateLink"
    // InternalSparrow.g:2502:1: entryRuleOperateLink returns [EObject current=null] : iv_ruleOperateLink= ruleOperateLink EOF ;
    public final EObject entryRuleOperateLink() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperateLink = null;


        try {
            // InternalSparrow.g:2502:52: (iv_ruleOperateLink= ruleOperateLink EOF )
            // InternalSparrow.g:2503:2: iv_ruleOperateLink= ruleOperateLink EOF
            {
             newCompositeNode(grammarAccess.getOperateLinkRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOperateLink=ruleOperateLink();

            state._fsp--;

             current =iv_ruleOperateLink; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOperateLink"


    // $ANTLR start "ruleOperateLink"
    // InternalSparrow.g:2509:1: ruleOperateLink returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_firstOperation_2_0= ruletrueOperation ) ) | ( (otherlv_3= RULE_ID ) ) ) ( (lv_andOrLink_4_0= ruleAndOrOperationLink ) )* ) ;
    public final EObject ruleOperateLink() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_firstOperation_2_0 = null;

        EObject lv_andOrLink_4_0 = null;



        	enterRule();

        try {
            // InternalSparrow.g:2515:2: ( ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_firstOperation_2_0= ruletrueOperation ) ) | ( (otherlv_3= RULE_ID ) ) ) ( (lv_andOrLink_4_0= ruleAndOrOperationLink ) )* ) )
            // InternalSparrow.g:2516:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_firstOperation_2_0= ruletrueOperation ) ) | ( (otherlv_3= RULE_ID ) ) ) ( (lv_andOrLink_4_0= ruleAndOrOperationLink ) )* )
            {
            // InternalSparrow.g:2516:2: ( ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_firstOperation_2_0= ruletrueOperation ) ) | ( (otherlv_3= RULE_ID ) ) ) ( (lv_andOrLink_4_0= ruleAndOrOperationLink ) )* )
            // InternalSparrow.g:2517:3: ( (lv_name_0_0= RULE_ID ) ) otherlv_1= ':' ( ( (lv_firstOperation_2_0= ruletrueOperation ) ) | ( (otherlv_3= RULE_ID ) ) ) ( (lv_andOrLink_4_0= ruleAndOrOperationLink ) )*
            {
            // InternalSparrow.g:2517:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalSparrow.g:2518:4: (lv_name_0_0= RULE_ID )
            {
            // InternalSparrow.g:2518:4: (lv_name_0_0= RULE_ID )
            // InternalSparrow.g:2519:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_16); 

            					newLeafNode(lv_name_0_0, grammarAccess.getOperateLinkAccess().getNameIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOperateLinkRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_1=(Token)match(input,21,FOLLOW_38); 

            			newLeafNode(otherlv_1, grammarAccess.getOperateLinkAccess().getColonKeyword_1());
            		
            // InternalSparrow.g:2539:3: ( ( (lv_firstOperation_2_0= ruletrueOperation ) ) | ( (otherlv_3= RULE_ID ) ) )
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( ((LA37_0>=105 && LA37_0<=107)||LA37_0==114) ) {
                alt37=1;
            }
            else if ( (LA37_0==RULE_ID) ) {
                alt37=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }
            switch (alt37) {
                case 1 :
                    // InternalSparrow.g:2540:4: ( (lv_firstOperation_2_0= ruletrueOperation ) )
                    {
                    // InternalSparrow.g:2540:4: ( (lv_firstOperation_2_0= ruletrueOperation ) )
                    // InternalSparrow.g:2541:5: (lv_firstOperation_2_0= ruletrueOperation )
                    {
                    // InternalSparrow.g:2541:5: (lv_firstOperation_2_0= ruletrueOperation )
                    // InternalSparrow.g:2542:6: lv_firstOperation_2_0= ruletrueOperation
                    {

                    						newCompositeNode(grammarAccess.getOperateLinkAccess().getFirstOperationTrueOperationParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_39);
                    lv_firstOperation_2_0=ruletrueOperation();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getOperateLinkRule());
                    						}
                    						set(
                    							current,
                    							"firstOperation",
                    							lv_firstOperation_2_0,
                    							"org.xtext.example.mydsl.Sparrow.trueOperation");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSparrow.g:2560:4: ( (otherlv_3= RULE_ID ) )
                    {
                    // InternalSparrow.g:2560:4: ( (otherlv_3= RULE_ID ) )
                    // InternalSparrow.g:2561:5: (otherlv_3= RULE_ID )
                    {
                    // InternalSparrow.g:2561:5: (otherlv_3= RULE_ID )
                    // InternalSparrow.g:2562:6: otherlv_3= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getOperateLinkRule());
                    						}
                    					
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_39); 

                    						newLeafNode(otherlv_3, grammarAccess.getOperateLinkAccess().getLinkOperationOperateLinkCrossReference_2_1_0());
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalSparrow.g:2574:3: ( (lv_andOrLink_4_0= ruleAndOrOperationLink ) )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==69) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalSparrow.g:2575:4: (lv_andOrLink_4_0= ruleAndOrOperationLink )
            	    {
            	    // InternalSparrow.g:2575:4: (lv_andOrLink_4_0= ruleAndOrOperationLink )
            	    // InternalSparrow.g:2576:5: lv_andOrLink_4_0= ruleAndOrOperationLink
            	    {

            	    					newCompositeNode(grammarAccess.getOperateLinkAccess().getAndOrLinkAndOrOperationLinkParserRuleCall_3_0());
            	    				
            	    pushFollow(FOLLOW_39);
            	    lv_andOrLink_4_0=ruleAndOrOperationLink();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getOperateLinkRule());
            	    					}
            	    					add(
            	    						current,
            	    						"andOrLink",
            	    						lv_andOrLink_4_0,
            	    						"org.xtext.example.mydsl.Sparrow.AndOrOperationLink");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop38;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOperateLink"


    // $ANTLR start "entryRuleRuleStructure"
    // InternalSparrow.g:2597:1: entryRuleRuleStructure returns [EObject current=null] : iv_ruleRuleStructure= ruleRuleStructure EOF ;
    public final EObject entryRuleRuleStructure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleStructure = null;


        try {
            // InternalSparrow.g:2597:54: (iv_ruleRuleStructure= ruleRuleStructure EOF )
            // InternalSparrow.g:2598:2: iv_ruleRuleStructure= ruleRuleStructure EOF
            {
             newCompositeNode(grammarAccess.getRuleStructureRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRuleStructure=ruleRuleStructure();

            state._fsp--;

             current =iv_ruleRuleStructure; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRuleStructure"


    // $ANTLR start "ruleRuleStructure"
    // InternalSparrow.g:2604:1: ruleRuleStructure returns [EObject current=null] : (otherlv_0= 'Rules' otherlv_1= '{' ( (lv_manyRuleExpression_2_0= ruleManyRuleExpression ) )+ otherlv_3= '}' ) ;
    public final EObject ruleRuleStructure() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_manyRuleExpression_2_0 = null;



        	enterRule();

        try {
            // InternalSparrow.g:2610:2: ( (otherlv_0= 'Rules' otherlv_1= '{' ( (lv_manyRuleExpression_2_0= ruleManyRuleExpression ) )+ otherlv_3= '}' ) )
            // InternalSparrow.g:2611:2: (otherlv_0= 'Rules' otherlv_1= '{' ( (lv_manyRuleExpression_2_0= ruleManyRuleExpression ) )+ otherlv_3= '}' )
            {
            // InternalSparrow.g:2611:2: (otherlv_0= 'Rules' otherlv_1= '{' ( (lv_manyRuleExpression_2_0= ruleManyRuleExpression ) )+ otherlv_3= '}' )
            // InternalSparrow.g:2612:3: otherlv_0= 'Rules' otherlv_1= '{' ( (lv_manyRuleExpression_2_0= ruleManyRuleExpression ) )+ otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,72,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getRuleStructureAccess().getRulesKeyword_0());
            		
            otherlv_1=(Token)match(input,18,FOLLOW_40); 

            			newLeafNode(otherlv_1, grammarAccess.getRuleStructureAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalSparrow.g:2620:3: ( (lv_manyRuleExpression_2_0= ruleManyRuleExpression ) )+
            int cnt39=0;
            loop39:
            do {
                int alt39=2;
                int LA39_0 = input.LA(1);

                if ( (LA39_0==RULE_ID||(LA39_0>=73 && LA39_0<=75)||LA39_0==81) ) {
                    alt39=1;
                }


                switch (alt39) {
            	case 1 :
            	    // InternalSparrow.g:2621:4: (lv_manyRuleExpression_2_0= ruleManyRuleExpression )
            	    {
            	    // InternalSparrow.g:2621:4: (lv_manyRuleExpression_2_0= ruleManyRuleExpression )
            	    // InternalSparrow.g:2622:5: lv_manyRuleExpression_2_0= ruleManyRuleExpression
            	    {

            	    					newCompositeNode(grammarAccess.getRuleStructureAccess().getManyRuleExpressionManyRuleExpressionParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_41);
            	    lv_manyRuleExpression_2_0=ruleManyRuleExpression();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getRuleStructureRule());
            	    					}
            	    					add(
            	    						current,
            	    						"manyRuleExpression",
            	    						lv_manyRuleExpression_2_0,
            	    						"org.xtext.example.mydsl.Sparrow.ManyRuleExpression");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt39 >= 1 ) break loop39;
                        EarlyExitException eee =
                            new EarlyExitException(39, input);
                        throw eee;
                }
                cnt39++;
            } while (true);

            otherlv_3=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getRuleStructureAccess().getRightCurlyBracketKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRuleStructure"


    // $ANTLR start "entryRuleManyRuleExpression"
    // InternalSparrow.g:2647:1: entryRuleManyRuleExpression returns [EObject current=null] : iv_ruleManyRuleExpression= ruleManyRuleExpression EOF ;
    public final EObject entryRuleManyRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleManyRuleExpression = null;


        try {
            // InternalSparrow.g:2647:59: (iv_ruleManyRuleExpression= ruleManyRuleExpression EOF )
            // InternalSparrow.g:2648:2: iv_ruleManyRuleExpression= ruleManyRuleExpression EOF
            {
             newCompositeNode(grammarAccess.getManyRuleExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleManyRuleExpression=ruleManyRuleExpression();

            state._fsp--;

             current =iv_ruleManyRuleExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleManyRuleExpression"


    // $ANTLR start "ruleManyRuleExpression"
    // InternalSparrow.g:2654:1: ruleManyRuleExpression returns [EObject current=null] : (this_ExclusiveExpression_0= ruleExclusiveExpression | this_ParallelExpression_1= ruleParallelExpression | this_RegularRuleExpression_2= ruleRegularRuleExpression | this_AdditionExpression_3= ruleAdditionExpression ) ;
    public final EObject ruleManyRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ExclusiveExpression_0 = null;

        EObject this_ParallelExpression_1 = null;

        EObject this_RegularRuleExpression_2 = null;

        EObject this_AdditionExpression_3 = null;



        	enterRule();

        try {
            // InternalSparrow.g:2660:2: ( (this_ExclusiveExpression_0= ruleExclusiveExpression | this_ParallelExpression_1= ruleParallelExpression | this_RegularRuleExpression_2= ruleRegularRuleExpression | this_AdditionExpression_3= ruleAdditionExpression ) )
            // InternalSparrow.g:2661:2: (this_ExclusiveExpression_0= ruleExclusiveExpression | this_ParallelExpression_1= ruleParallelExpression | this_RegularRuleExpression_2= ruleRegularRuleExpression | this_AdditionExpression_3= ruleAdditionExpression )
            {
            // InternalSparrow.g:2661:2: (this_ExclusiveExpression_0= ruleExclusiveExpression | this_ParallelExpression_1= ruleParallelExpression | this_RegularRuleExpression_2= ruleRegularRuleExpression | this_AdditionExpression_3= ruleAdditionExpression )
            int alt40=4;
            switch ( input.LA(1) ) {
            case 74:
                {
                alt40=1;
                }
                break;
            case 73:
                {
                alt40=2;
                }
                break;
            case RULE_ID:
            case 81:
                {
                alt40=3;
                }
                break;
            case 75:
                {
                alt40=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 40, 0, input);

                throw nvae;
            }

            switch (alt40) {
                case 1 :
                    // InternalSparrow.g:2662:3: this_ExclusiveExpression_0= ruleExclusiveExpression
                    {

                    			newCompositeNode(grammarAccess.getManyRuleExpressionAccess().getExclusiveExpressionParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ExclusiveExpression_0=ruleExclusiveExpression();

                    state._fsp--;


                    			current = this_ExclusiveExpression_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalSparrow.g:2671:3: this_ParallelExpression_1= ruleParallelExpression
                    {

                    			newCompositeNode(grammarAccess.getManyRuleExpressionAccess().getParallelExpressionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ParallelExpression_1=ruleParallelExpression();

                    state._fsp--;


                    			current = this_ParallelExpression_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalSparrow.g:2680:3: this_RegularRuleExpression_2= ruleRegularRuleExpression
                    {

                    			newCompositeNode(grammarAccess.getManyRuleExpressionAccess().getRegularRuleExpressionParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_RegularRuleExpression_2=ruleRegularRuleExpression();

                    state._fsp--;


                    			current = this_RegularRuleExpression_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalSparrow.g:2689:3: this_AdditionExpression_3= ruleAdditionExpression
                    {

                    			newCompositeNode(grammarAccess.getManyRuleExpressionAccess().getAdditionExpressionParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_AdditionExpression_3=ruleAdditionExpression();

                    state._fsp--;


                    			current = this_AdditionExpression_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleManyRuleExpression"


    // $ANTLR start "entryRuleParallelExpression"
    // InternalSparrow.g:2701:1: entryRuleParallelExpression returns [EObject current=null] : iv_ruleParallelExpression= ruleParallelExpression EOF ;
    public final EObject entryRuleParallelExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParallelExpression = null;


        try {
            // InternalSparrow.g:2701:59: (iv_ruleParallelExpression= ruleParallelExpression EOF )
            // InternalSparrow.g:2702:2: iv_ruleParallelExpression= ruleParallelExpression EOF
            {
             newCompositeNode(grammarAccess.getParallelExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleParallelExpression=ruleParallelExpression();

            state._fsp--;

             current =iv_ruleParallelExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParallelExpression"


    // $ANTLR start "ruleParallelExpression"
    // InternalSparrow.g:2708:1: ruleParallelExpression returns [EObject current=null] : (otherlv_0= 'Exclusive' otherlv_1= '[' ( (lv_ruleExpression_2_0= ruleRuleExpression ) ) (otherlv_3= ';' ( (lv_ruleExpression_4_0= ruleRuleExpression ) ) )* otherlv_5= ']' ) ;
    public final EObject ruleParallelExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_ruleExpression_2_0 = null;

        EObject lv_ruleExpression_4_0 = null;



        	enterRule();

        try {
            // InternalSparrow.g:2714:2: ( (otherlv_0= 'Exclusive' otherlv_1= '[' ( (lv_ruleExpression_2_0= ruleRuleExpression ) ) (otherlv_3= ';' ( (lv_ruleExpression_4_0= ruleRuleExpression ) ) )* otherlv_5= ']' ) )
            // InternalSparrow.g:2715:2: (otherlv_0= 'Exclusive' otherlv_1= '[' ( (lv_ruleExpression_2_0= ruleRuleExpression ) ) (otherlv_3= ';' ( (lv_ruleExpression_4_0= ruleRuleExpression ) ) )* otherlv_5= ']' )
            {
            // InternalSparrow.g:2715:2: (otherlv_0= 'Exclusive' otherlv_1= '[' ( (lv_ruleExpression_2_0= ruleRuleExpression ) ) (otherlv_3= ';' ( (lv_ruleExpression_4_0= ruleRuleExpression ) ) )* otherlv_5= ']' )
            // InternalSparrow.g:2716:3: otherlv_0= 'Exclusive' otherlv_1= '[' ( (lv_ruleExpression_2_0= ruleRuleExpression ) ) (otherlv_3= ';' ( (lv_ruleExpression_4_0= ruleRuleExpression ) ) )* otherlv_5= ']'
            {
            otherlv_0=(Token)match(input,73,FOLLOW_33); 

            			newLeafNode(otherlv_0, grammarAccess.getParallelExpressionAccess().getExclusiveKeyword_0());
            		
            otherlv_1=(Token)match(input,67,FOLLOW_42); 

            			newLeafNode(otherlv_1, grammarAccess.getParallelExpressionAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalSparrow.g:2724:3: ( (lv_ruleExpression_2_0= ruleRuleExpression ) )
            // InternalSparrow.g:2725:4: (lv_ruleExpression_2_0= ruleRuleExpression )
            {
            // InternalSparrow.g:2725:4: (lv_ruleExpression_2_0= ruleRuleExpression )
            // InternalSparrow.g:2726:5: lv_ruleExpression_2_0= ruleRuleExpression
            {

            					newCompositeNode(grammarAccess.getParallelExpressionAccess().getRuleExpressionRuleExpressionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_43);
            lv_ruleExpression_2_0=ruleRuleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getParallelExpressionRule());
            					}
            					add(
            						current,
            						"ruleExpression",
            						lv_ruleExpression_2_0,
            						"org.xtext.example.mydsl.Sparrow.RuleExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSparrow.g:2743:3: (otherlv_3= ';' ( (lv_ruleExpression_4_0= ruleRuleExpression ) ) )*
            loop41:
            do {
                int alt41=2;
                int LA41_0 = input.LA(1);

                if ( (LA41_0==23) ) {
                    alt41=1;
                }


                switch (alt41) {
            	case 1 :
            	    // InternalSparrow.g:2744:4: otherlv_3= ';' ( (lv_ruleExpression_4_0= ruleRuleExpression ) )
            	    {
            	    otherlv_3=(Token)match(input,23,FOLLOW_42); 

            	    				newLeafNode(otherlv_3, grammarAccess.getParallelExpressionAccess().getSemicolonKeyword_3_0());
            	    			
            	    // InternalSparrow.g:2748:4: ( (lv_ruleExpression_4_0= ruleRuleExpression ) )
            	    // InternalSparrow.g:2749:5: (lv_ruleExpression_4_0= ruleRuleExpression )
            	    {
            	    // InternalSparrow.g:2749:5: (lv_ruleExpression_4_0= ruleRuleExpression )
            	    // InternalSparrow.g:2750:6: lv_ruleExpression_4_0= ruleRuleExpression
            	    {

            	    						newCompositeNode(grammarAccess.getParallelExpressionAccess().getRuleExpressionRuleExpressionParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_43);
            	    lv_ruleExpression_4_0=ruleRuleExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getParallelExpressionRule());
            	    						}
            	    						add(
            	    							current,
            	    							"ruleExpression",
            	    							lv_ruleExpression_4_0,
            	    							"org.xtext.example.mydsl.Sparrow.RuleExpression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop41;
                }
            } while (true);

            otherlv_5=(Token)match(input,68,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getParallelExpressionAccess().getRightSquareBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParallelExpression"


    // $ANTLR start "entryRuleExclusiveExpression"
    // InternalSparrow.g:2776:1: entryRuleExclusiveExpression returns [EObject current=null] : iv_ruleExclusiveExpression= ruleExclusiveExpression EOF ;
    public final EObject entryRuleExclusiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExclusiveExpression = null;


        try {
            // InternalSparrow.g:2776:60: (iv_ruleExclusiveExpression= ruleExclusiveExpression EOF )
            // InternalSparrow.g:2777:2: iv_ruleExclusiveExpression= ruleExclusiveExpression EOF
            {
             newCompositeNode(grammarAccess.getExclusiveExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExclusiveExpression=ruleExclusiveExpression();

            state._fsp--;

             current =iv_ruleExclusiveExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExclusiveExpression"


    // $ANTLR start "ruleExclusiveExpression"
    // InternalSparrow.g:2783:1: ruleExclusiveExpression returns [EObject current=null] : (otherlv_0= 'Parallel' otherlv_1= '[' ( (lv_ruleExpression_2_0= ruleRuleExpression ) ) (otherlv_3= ';' ( (lv_ruleExpression_4_0= ruleRuleExpression ) ) )* otherlv_5= ']' ) ;
    public final EObject ruleExclusiveExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_ruleExpression_2_0 = null;

        EObject lv_ruleExpression_4_0 = null;



        	enterRule();

        try {
            // InternalSparrow.g:2789:2: ( (otherlv_0= 'Parallel' otherlv_1= '[' ( (lv_ruleExpression_2_0= ruleRuleExpression ) ) (otherlv_3= ';' ( (lv_ruleExpression_4_0= ruleRuleExpression ) ) )* otherlv_5= ']' ) )
            // InternalSparrow.g:2790:2: (otherlv_0= 'Parallel' otherlv_1= '[' ( (lv_ruleExpression_2_0= ruleRuleExpression ) ) (otherlv_3= ';' ( (lv_ruleExpression_4_0= ruleRuleExpression ) ) )* otherlv_5= ']' )
            {
            // InternalSparrow.g:2790:2: (otherlv_0= 'Parallel' otherlv_1= '[' ( (lv_ruleExpression_2_0= ruleRuleExpression ) ) (otherlv_3= ';' ( (lv_ruleExpression_4_0= ruleRuleExpression ) ) )* otherlv_5= ']' )
            // InternalSparrow.g:2791:3: otherlv_0= 'Parallel' otherlv_1= '[' ( (lv_ruleExpression_2_0= ruleRuleExpression ) ) (otherlv_3= ';' ( (lv_ruleExpression_4_0= ruleRuleExpression ) ) )* otherlv_5= ']'
            {
            otherlv_0=(Token)match(input,74,FOLLOW_33); 

            			newLeafNode(otherlv_0, grammarAccess.getExclusiveExpressionAccess().getParallelKeyword_0());
            		
            otherlv_1=(Token)match(input,67,FOLLOW_42); 

            			newLeafNode(otherlv_1, grammarAccess.getExclusiveExpressionAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalSparrow.g:2799:3: ( (lv_ruleExpression_2_0= ruleRuleExpression ) )
            // InternalSparrow.g:2800:4: (lv_ruleExpression_2_0= ruleRuleExpression )
            {
            // InternalSparrow.g:2800:4: (lv_ruleExpression_2_0= ruleRuleExpression )
            // InternalSparrow.g:2801:5: lv_ruleExpression_2_0= ruleRuleExpression
            {

            					newCompositeNode(grammarAccess.getExclusiveExpressionAccess().getRuleExpressionRuleExpressionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_43);
            lv_ruleExpression_2_0=ruleRuleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getExclusiveExpressionRule());
            					}
            					add(
            						current,
            						"ruleExpression",
            						lv_ruleExpression_2_0,
            						"org.xtext.example.mydsl.Sparrow.RuleExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSparrow.g:2818:3: (otherlv_3= ';' ( (lv_ruleExpression_4_0= ruleRuleExpression ) ) )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==23) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalSparrow.g:2819:4: otherlv_3= ';' ( (lv_ruleExpression_4_0= ruleRuleExpression ) )
            	    {
            	    otherlv_3=(Token)match(input,23,FOLLOW_42); 

            	    				newLeafNode(otherlv_3, grammarAccess.getExclusiveExpressionAccess().getSemicolonKeyword_3_0());
            	    			
            	    // InternalSparrow.g:2823:4: ( (lv_ruleExpression_4_0= ruleRuleExpression ) )
            	    // InternalSparrow.g:2824:5: (lv_ruleExpression_4_0= ruleRuleExpression )
            	    {
            	    // InternalSparrow.g:2824:5: (lv_ruleExpression_4_0= ruleRuleExpression )
            	    // InternalSparrow.g:2825:6: lv_ruleExpression_4_0= ruleRuleExpression
            	    {

            	    						newCompositeNode(grammarAccess.getExclusiveExpressionAccess().getRuleExpressionRuleExpressionParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_43);
            	    lv_ruleExpression_4_0=ruleRuleExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getExclusiveExpressionRule());
            	    						}
            	    						add(
            	    							current,
            	    							"ruleExpression",
            	    							lv_ruleExpression_4_0,
            	    							"org.xtext.example.mydsl.Sparrow.RuleExpression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);

            otherlv_5=(Token)match(input,68,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getExclusiveExpressionAccess().getRightSquareBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExclusiveExpression"


    // $ANTLR start "entryRuleRegularRuleExpression"
    // InternalSparrow.g:2851:1: entryRuleRegularRuleExpression returns [EObject current=null] : iv_ruleRegularRuleExpression= ruleRegularRuleExpression EOF ;
    public final EObject entryRuleRegularRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegularRuleExpression = null;


        try {
            // InternalSparrow.g:2851:62: (iv_ruleRegularRuleExpression= ruleRegularRuleExpression EOF )
            // InternalSparrow.g:2852:2: iv_ruleRegularRuleExpression= ruleRegularRuleExpression EOF
            {
             newCompositeNode(grammarAccess.getRegularRuleExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRegularRuleExpression=ruleRegularRuleExpression();

            state._fsp--;

             current =iv_ruleRegularRuleExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRegularRuleExpression"


    // $ANTLR start "ruleRegularRuleExpression"
    // InternalSparrow.g:2858:1: ruleRegularRuleExpression returns [EObject current=null] : ( ( (lv_ruleExpression_0_0= ruleRuleExpression ) ) (otherlv_1= ';' ( (lv_ruleExpression_2_0= ruleRuleExpression ) ) )* ) ;
    public final EObject ruleRegularRuleExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_ruleExpression_0_0 = null;

        EObject lv_ruleExpression_2_0 = null;



        	enterRule();

        try {
            // InternalSparrow.g:2864:2: ( ( ( (lv_ruleExpression_0_0= ruleRuleExpression ) ) (otherlv_1= ';' ( (lv_ruleExpression_2_0= ruleRuleExpression ) ) )* ) )
            // InternalSparrow.g:2865:2: ( ( (lv_ruleExpression_0_0= ruleRuleExpression ) ) (otherlv_1= ';' ( (lv_ruleExpression_2_0= ruleRuleExpression ) ) )* )
            {
            // InternalSparrow.g:2865:2: ( ( (lv_ruleExpression_0_0= ruleRuleExpression ) ) (otherlv_1= ';' ( (lv_ruleExpression_2_0= ruleRuleExpression ) ) )* )
            // InternalSparrow.g:2866:3: ( (lv_ruleExpression_0_0= ruleRuleExpression ) ) (otherlv_1= ';' ( (lv_ruleExpression_2_0= ruleRuleExpression ) ) )*
            {
            // InternalSparrow.g:2866:3: ( (lv_ruleExpression_0_0= ruleRuleExpression ) )
            // InternalSparrow.g:2867:4: (lv_ruleExpression_0_0= ruleRuleExpression )
            {
            // InternalSparrow.g:2867:4: (lv_ruleExpression_0_0= ruleRuleExpression )
            // InternalSparrow.g:2868:5: lv_ruleExpression_0_0= ruleRuleExpression
            {

            					newCompositeNode(grammarAccess.getRegularRuleExpressionAccess().getRuleExpressionRuleExpressionParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_44);
            lv_ruleExpression_0_0=ruleRuleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRegularRuleExpressionRule());
            					}
            					add(
            						current,
            						"ruleExpression",
            						lv_ruleExpression_0_0,
            						"org.xtext.example.mydsl.Sparrow.RuleExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSparrow.g:2885:3: (otherlv_1= ';' ( (lv_ruleExpression_2_0= ruleRuleExpression ) ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==23) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalSparrow.g:2886:4: otherlv_1= ';' ( (lv_ruleExpression_2_0= ruleRuleExpression ) )
            	    {
            	    otherlv_1=(Token)match(input,23,FOLLOW_42); 

            	    				newLeafNode(otherlv_1, grammarAccess.getRegularRuleExpressionAccess().getSemicolonKeyword_1_0());
            	    			
            	    // InternalSparrow.g:2890:4: ( (lv_ruleExpression_2_0= ruleRuleExpression ) )
            	    // InternalSparrow.g:2891:5: (lv_ruleExpression_2_0= ruleRuleExpression )
            	    {
            	    // InternalSparrow.g:2891:5: (lv_ruleExpression_2_0= ruleRuleExpression )
            	    // InternalSparrow.g:2892:6: lv_ruleExpression_2_0= ruleRuleExpression
            	    {

            	    						newCompositeNode(grammarAccess.getRegularRuleExpressionAccess().getRuleExpressionRuleExpressionParserRuleCall_1_1_0());
            	    					
            	    pushFollow(FOLLOW_44);
            	    lv_ruleExpression_2_0=ruleRuleExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getRegularRuleExpressionRule());
            	    						}
            	    						add(
            	    							current,
            	    							"ruleExpression",
            	    							lv_ruleExpression_2_0,
            	    							"org.xtext.example.mydsl.Sparrow.RuleExpression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRegularRuleExpression"


    // $ANTLR start "entryRuleAdditionExpression"
    // InternalSparrow.g:2914:1: entryRuleAdditionExpression returns [EObject current=null] : iv_ruleAdditionExpression= ruleAdditionExpression EOF ;
    public final EObject entryRuleAdditionExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditionExpression = null;


        try {
            // InternalSparrow.g:2914:59: (iv_ruleAdditionExpression= ruleAdditionExpression EOF )
            // InternalSparrow.g:2915:2: iv_ruleAdditionExpression= ruleAdditionExpression EOF
            {
             newCompositeNode(grammarAccess.getAdditionExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAdditionExpression=ruleAdditionExpression();

            state._fsp--;

             current =iv_ruleAdditionExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAdditionExpression"


    // $ANTLR start "ruleAdditionExpression"
    // InternalSparrow.g:2921:1: ruleAdditionExpression returns [EObject current=null] : (otherlv_0= 'Additional' otherlv_1= '[' ( (lv_ruleExpression_2_0= ruleRuleExpression ) ) (otherlv_3= ';' ( (lv_ruleExpression_4_0= ruleRuleExpression ) ) )* otherlv_5= ']' ) ;
    public final EObject ruleAdditionExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_ruleExpression_2_0 = null;

        EObject lv_ruleExpression_4_0 = null;



        	enterRule();

        try {
            // InternalSparrow.g:2927:2: ( (otherlv_0= 'Additional' otherlv_1= '[' ( (lv_ruleExpression_2_0= ruleRuleExpression ) ) (otherlv_3= ';' ( (lv_ruleExpression_4_0= ruleRuleExpression ) ) )* otherlv_5= ']' ) )
            // InternalSparrow.g:2928:2: (otherlv_0= 'Additional' otherlv_1= '[' ( (lv_ruleExpression_2_0= ruleRuleExpression ) ) (otherlv_3= ';' ( (lv_ruleExpression_4_0= ruleRuleExpression ) ) )* otherlv_5= ']' )
            {
            // InternalSparrow.g:2928:2: (otherlv_0= 'Additional' otherlv_1= '[' ( (lv_ruleExpression_2_0= ruleRuleExpression ) ) (otherlv_3= ';' ( (lv_ruleExpression_4_0= ruleRuleExpression ) ) )* otherlv_5= ']' )
            // InternalSparrow.g:2929:3: otherlv_0= 'Additional' otherlv_1= '[' ( (lv_ruleExpression_2_0= ruleRuleExpression ) ) (otherlv_3= ';' ( (lv_ruleExpression_4_0= ruleRuleExpression ) ) )* otherlv_5= ']'
            {
            otherlv_0=(Token)match(input,75,FOLLOW_33); 

            			newLeafNode(otherlv_0, grammarAccess.getAdditionExpressionAccess().getAdditionalKeyword_0());
            		
            otherlv_1=(Token)match(input,67,FOLLOW_42); 

            			newLeafNode(otherlv_1, grammarAccess.getAdditionExpressionAccess().getLeftSquareBracketKeyword_1());
            		
            // InternalSparrow.g:2937:3: ( (lv_ruleExpression_2_0= ruleRuleExpression ) )
            // InternalSparrow.g:2938:4: (lv_ruleExpression_2_0= ruleRuleExpression )
            {
            // InternalSparrow.g:2938:4: (lv_ruleExpression_2_0= ruleRuleExpression )
            // InternalSparrow.g:2939:5: lv_ruleExpression_2_0= ruleRuleExpression
            {

            					newCompositeNode(grammarAccess.getAdditionExpressionAccess().getRuleExpressionRuleExpressionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_43);
            lv_ruleExpression_2_0=ruleRuleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAdditionExpressionRule());
            					}
            					add(
            						current,
            						"ruleExpression",
            						lv_ruleExpression_2_0,
            						"org.xtext.example.mydsl.Sparrow.RuleExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSparrow.g:2956:3: (otherlv_3= ';' ( (lv_ruleExpression_4_0= ruleRuleExpression ) ) )*
            loop44:
            do {
                int alt44=2;
                int LA44_0 = input.LA(1);

                if ( (LA44_0==23) ) {
                    alt44=1;
                }


                switch (alt44) {
            	case 1 :
            	    // InternalSparrow.g:2957:4: otherlv_3= ';' ( (lv_ruleExpression_4_0= ruleRuleExpression ) )
            	    {
            	    otherlv_3=(Token)match(input,23,FOLLOW_42); 

            	    				newLeafNode(otherlv_3, grammarAccess.getAdditionExpressionAccess().getSemicolonKeyword_3_0());
            	    			
            	    // InternalSparrow.g:2961:4: ( (lv_ruleExpression_4_0= ruleRuleExpression ) )
            	    // InternalSparrow.g:2962:5: (lv_ruleExpression_4_0= ruleRuleExpression )
            	    {
            	    // InternalSparrow.g:2962:5: (lv_ruleExpression_4_0= ruleRuleExpression )
            	    // InternalSparrow.g:2963:6: lv_ruleExpression_4_0= ruleRuleExpression
            	    {

            	    						newCompositeNode(grammarAccess.getAdditionExpressionAccess().getRuleExpressionRuleExpressionParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_43);
            	    lv_ruleExpression_4_0=ruleRuleExpression();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAdditionExpressionRule());
            	    						}
            	    						add(
            	    							current,
            	    							"ruleExpression",
            	    							lv_ruleExpression_4_0,
            	    							"org.xtext.example.mydsl.Sparrow.RuleExpression");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop44;
                }
            } while (true);

            otherlv_5=(Token)match(input,68,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getAdditionExpressionAccess().getRightSquareBracketKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAdditionExpression"


    // $ANTLR start "entryRuleTotalCondition"
    // InternalSparrow.g:2989:1: entryRuleTotalCondition returns [EObject current=null] : iv_ruleTotalCondition= ruleTotalCondition EOF ;
    public final EObject entryRuleTotalCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTotalCondition = null;


        try {
            // InternalSparrow.g:2989:55: (iv_ruleTotalCondition= ruleTotalCondition EOF )
            // InternalSparrow.g:2990:2: iv_ruleTotalCondition= ruleTotalCondition EOF
            {
             newCompositeNode(grammarAccess.getTotalConditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTotalCondition=ruleTotalCondition();

            state._fsp--;

             current =iv_ruleTotalCondition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTotalCondition"


    // $ANTLR start "ruleTotalCondition"
    // InternalSparrow.g:2996:1: ruleTotalCondition returns [EObject current=null] : (otherlv_0= 'If:' ( ( (lv_condition_1_0= ruleSingleCondition ) ) | ( (lv_linkCondition_2_0= ruleSingleLinkCondition ) ) ) ( (lv_andorcondition_3_0= ruleAndOrCondition ) )* otherlv_4= ',' ) ;
    public final EObject ruleTotalCondition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        EObject lv_condition_1_0 = null;

        EObject lv_linkCondition_2_0 = null;

        EObject lv_andorcondition_3_0 = null;



        	enterRule();

        try {
            // InternalSparrow.g:3002:2: ( (otherlv_0= 'If:' ( ( (lv_condition_1_0= ruleSingleCondition ) ) | ( (lv_linkCondition_2_0= ruleSingleLinkCondition ) ) ) ( (lv_andorcondition_3_0= ruleAndOrCondition ) )* otherlv_4= ',' ) )
            // InternalSparrow.g:3003:2: (otherlv_0= 'If:' ( ( (lv_condition_1_0= ruleSingleCondition ) ) | ( (lv_linkCondition_2_0= ruleSingleLinkCondition ) ) ) ( (lv_andorcondition_3_0= ruleAndOrCondition ) )* otherlv_4= ',' )
            {
            // InternalSparrow.g:3003:2: (otherlv_0= 'If:' ( ( (lv_condition_1_0= ruleSingleCondition ) ) | ( (lv_linkCondition_2_0= ruleSingleLinkCondition ) ) ) ( (lv_andorcondition_3_0= ruleAndOrCondition ) )* otherlv_4= ',' )
            // InternalSparrow.g:3004:3: otherlv_0= 'If:' ( ( (lv_condition_1_0= ruleSingleCondition ) ) | ( (lv_linkCondition_2_0= ruleSingleLinkCondition ) ) ) ( (lv_andorcondition_3_0= ruleAndOrCondition ) )* otherlv_4= ','
            {
            otherlv_0=(Token)match(input,76,FOLLOW_37); 

            			newLeafNode(otherlv_0, grammarAccess.getTotalConditionAccess().getIfKeyword_0());
            		
            // InternalSparrow.g:3008:3: ( ( (lv_condition_1_0= ruleSingleCondition ) ) | ( (lv_linkCondition_2_0= ruleSingleLinkCondition ) ) )
            int alt45=2;
            switch ( input.LA(1) ) {
            case 77:
                {
                int LA45_1 = input.LA(2);

                if ( (LA45_1==RULE_ID) ) {
                    alt45=2;
                }
                else if ( (LA45_1==85||(LA45_1>=87 && LA45_1<=89)||(LA45_1>=91 && LA45_1<=95)) ) {
                    alt45=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 45, 1, input);

                    throw nvae;
                }
                }
                break;
            case 85:
            case 87:
            case 88:
            case 89:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
                {
                alt45=1;
                }
                break;
            case RULE_ID:
                {
                alt45=2;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }

            switch (alt45) {
                case 1 :
                    // InternalSparrow.g:3009:4: ( (lv_condition_1_0= ruleSingleCondition ) )
                    {
                    // InternalSparrow.g:3009:4: ( (lv_condition_1_0= ruleSingleCondition ) )
                    // InternalSparrow.g:3010:5: (lv_condition_1_0= ruleSingleCondition )
                    {
                    // InternalSparrow.g:3010:5: (lv_condition_1_0= ruleSingleCondition )
                    // InternalSparrow.g:3011:6: lv_condition_1_0= ruleSingleCondition
                    {

                    						newCompositeNode(grammarAccess.getTotalConditionAccess().getConditionSingleConditionParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_45);
                    lv_condition_1_0=ruleSingleCondition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTotalConditionRule());
                    						}
                    						set(
                    							current,
                    							"condition",
                    							lv_condition_1_0,
                    							"org.xtext.example.mydsl.Sparrow.SingleCondition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSparrow.g:3029:4: ( (lv_linkCondition_2_0= ruleSingleLinkCondition ) )
                    {
                    // InternalSparrow.g:3029:4: ( (lv_linkCondition_2_0= ruleSingleLinkCondition ) )
                    // InternalSparrow.g:3030:5: (lv_linkCondition_2_0= ruleSingleLinkCondition )
                    {
                    // InternalSparrow.g:3030:5: (lv_linkCondition_2_0= ruleSingleLinkCondition )
                    // InternalSparrow.g:3031:6: lv_linkCondition_2_0= ruleSingleLinkCondition
                    {

                    						newCompositeNode(grammarAccess.getTotalConditionAccess().getLinkConditionSingleLinkConditionParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_45);
                    lv_linkCondition_2_0=ruleSingleLinkCondition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTotalConditionRule());
                    						}
                    						set(
                    							current,
                    							"linkCondition",
                    							lv_linkCondition_2_0,
                    							"org.xtext.example.mydsl.Sparrow.SingleLinkCondition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalSparrow.g:3049:3: ( (lv_andorcondition_3_0= ruleAndOrCondition ) )*
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( ((LA46_0>=69 && LA46_0<=70)) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalSparrow.g:3050:4: (lv_andorcondition_3_0= ruleAndOrCondition )
            	    {
            	    // InternalSparrow.g:3050:4: (lv_andorcondition_3_0= ruleAndOrCondition )
            	    // InternalSparrow.g:3051:5: lv_andorcondition_3_0= ruleAndOrCondition
            	    {

            	    					newCompositeNode(grammarAccess.getTotalConditionAccess().getAndorconditionAndOrConditionParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_45);
            	    lv_andorcondition_3_0=ruleAndOrCondition();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTotalConditionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"andorcondition",
            	    						lv_andorcondition_3_0,
            	    						"org.xtext.example.mydsl.Sparrow.AndOrCondition");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop46;
                }
            } while (true);

            otherlv_4=(Token)match(input,22,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getTotalConditionAccess().getCommaKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTotalCondition"


    // $ANTLR start "entryRuleSingleLinkCondition"
    // InternalSparrow.g:3076:1: entryRuleSingleLinkCondition returns [EObject current=null] : iv_ruleSingleLinkCondition= ruleSingleLinkCondition EOF ;
    public final EObject entryRuleSingleLinkCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleLinkCondition = null;


        try {
            // InternalSparrow.g:3076:60: (iv_ruleSingleLinkCondition= ruleSingleLinkCondition EOF )
            // InternalSparrow.g:3077:2: iv_ruleSingleLinkCondition= ruleSingleLinkCondition EOF
            {
             newCompositeNode(grammarAccess.getSingleLinkConditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSingleLinkCondition=ruleSingleLinkCondition();

            state._fsp--;

             current =iv_ruleSingleLinkCondition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSingleLinkCondition"


    // $ANTLR start "ruleSingleLinkCondition"
    // InternalSparrow.g:3083:1: ruleSingleLinkCondition returns [EObject current=null] : ( ( (lv_no_0_0= '!' ) )? ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleSingleLinkCondition() throws RecognitionException {
        EObject current = null;

        Token lv_no_0_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalSparrow.g:3089:2: ( ( ( (lv_no_0_0= '!' ) )? ( (otherlv_1= RULE_ID ) ) ) )
            // InternalSparrow.g:3090:2: ( ( (lv_no_0_0= '!' ) )? ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalSparrow.g:3090:2: ( ( (lv_no_0_0= '!' ) )? ( (otherlv_1= RULE_ID ) ) )
            // InternalSparrow.g:3091:3: ( (lv_no_0_0= '!' ) )? ( (otherlv_1= RULE_ID ) )
            {
            // InternalSparrow.g:3091:3: ( (lv_no_0_0= '!' ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==77) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalSparrow.g:3092:4: (lv_no_0_0= '!' )
                    {
                    // InternalSparrow.g:3092:4: (lv_no_0_0= '!' )
                    // InternalSparrow.g:3093:5: lv_no_0_0= '!'
                    {
                    lv_no_0_0=(Token)match(input,77,FOLLOW_3); 

                    					newLeafNode(lv_no_0_0, grammarAccess.getSingleLinkConditionAccess().getNoExclamationMarkKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getSingleLinkConditionRule());
                    					}
                    					setWithLastConsumed(current, "no", lv_no_0_0, "!");
                    				

                    }


                    }
                    break;

            }

            // InternalSparrow.g:3105:3: ( (otherlv_1= RULE_ID ) )
            // InternalSparrow.g:3106:4: (otherlv_1= RULE_ID )
            {
            // InternalSparrow.g:3106:4: (otherlv_1= RULE_ID )
            // InternalSparrow.g:3107:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSingleLinkConditionRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(otherlv_1, grammarAccess.getSingleLinkConditionAccess().getLinkConditionConditionLinkCrossReference_1_0());
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSingleLinkCondition"


    // $ANTLR start "entryRuleTotalOperation"
    // InternalSparrow.g:3122:1: entryRuleTotalOperation returns [EObject current=null] : iv_ruleTotalOperation= ruleTotalOperation EOF ;
    public final EObject entryRuleTotalOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTotalOperation = null;


        try {
            // InternalSparrow.g:3122:55: (iv_ruleTotalOperation= ruleTotalOperation EOF )
            // InternalSparrow.g:3123:2: iv_ruleTotalOperation= ruleTotalOperation EOF
            {
             newCompositeNode(grammarAccess.getTotalOperationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTotalOperation=ruleTotalOperation();

            state._fsp--;

             current =iv_ruleTotalOperation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTotalOperation"


    // $ANTLR start "ruleTotalOperation"
    // InternalSparrow.g:3129:1: ruleTotalOperation returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) )? (otherlv_2= 'G' ( (otherlv_3= RULE_ID ) ) )? ( ( (lv_firstOperation_4_0= ruletrueOperation ) ) | ( (otherlv_5= RULE_ID ) ) )? ( (lv_andor_6_0= ruleAndOrOperationLink ) )* ( (lv_timePoint_7_0= ruleTimepoint ) )? ( (lv_failresult_8_0= ruleFailResult ) )? ( (lv_thenoperation_9_0= ruleThenOperation ) )* ) ;
    public final EObject ruleTotalOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_firstOperation_4_0 = null;

        EObject lv_andor_6_0 = null;

        EObject lv_timePoint_7_0 = null;

        EObject lv_failresult_8_0 = null;

        EObject lv_thenoperation_9_0 = null;



        	enterRule();

        try {
            // InternalSparrow.g:3135:2: ( ( () ( (otherlv_1= RULE_ID ) )? (otherlv_2= 'G' ( (otherlv_3= RULE_ID ) ) )? ( ( (lv_firstOperation_4_0= ruletrueOperation ) ) | ( (otherlv_5= RULE_ID ) ) )? ( (lv_andor_6_0= ruleAndOrOperationLink ) )* ( (lv_timePoint_7_0= ruleTimepoint ) )? ( (lv_failresult_8_0= ruleFailResult ) )? ( (lv_thenoperation_9_0= ruleThenOperation ) )* ) )
            // InternalSparrow.g:3136:2: ( () ( (otherlv_1= RULE_ID ) )? (otherlv_2= 'G' ( (otherlv_3= RULE_ID ) ) )? ( ( (lv_firstOperation_4_0= ruletrueOperation ) ) | ( (otherlv_5= RULE_ID ) ) )? ( (lv_andor_6_0= ruleAndOrOperationLink ) )* ( (lv_timePoint_7_0= ruleTimepoint ) )? ( (lv_failresult_8_0= ruleFailResult ) )? ( (lv_thenoperation_9_0= ruleThenOperation ) )* )
            {
            // InternalSparrow.g:3136:2: ( () ( (otherlv_1= RULE_ID ) )? (otherlv_2= 'G' ( (otherlv_3= RULE_ID ) ) )? ( ( (lv_firstOperation_4_0= ruletrueOperation ) ) | ( (otherlv_5= RULE_ID ) ) )? ( (lv_andor_6_0= ruleAndOrOperationLink ) )* ( (lv_timePoint_7_0= ruleTimepoint ) )? ( (lv_failresult_8_0= ruleFailResult ) )? ( (lv_thenoperation_9_0= ruleThenOperation ) )* )
            // InternalSparrow.g:3137:3: () ( (otherlv_1= RULE_ID ) )? (otherlv_2= 'G' ( (otherlv_3= RULE_ID ) ) )? ( ( (lv_firstOperation_4_0= ruletrueOperation ) ) | ( (otherlv_5= RULE_ID ) ) )? ( (lv_andor_6_0= ruleAndOrOperationLink ) )* ( (lv_timePoint_7_0= ruleTimepoint ) )? ( (lv_failresult_8_0= ruleFailResult ) )? ( (lv_thenoperation_9_0= ruleThenOperation ) )*
            {
            // InternalSparrow.g:3137:3: ()
            // InternalSparrow.g:3138:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTotalOperationAccess().getTotalOperationAction_0(),
            					current);
            			

            }

            // InternalSparrow.g:3144:3: ( (otherlv_1= RULE_ID ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==RULE_ID) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // InternalSparrow.g:3145:4: (otherlv_1= RULE_ID )
                    {
                    // InternalSparrow.g:3145:4: (otherlv_1= RULE_ID )
                    // InternalSparrow.g:3146:5: otherlv_1= RULE_ID
                    {

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getTotalOperationRule());
                    					}
                    				
                    otherlv_1=(Token)match(input,RULE_ID,FOLLOW_46); 

                    					newLeafNode(otherlv_1, grammarAccess.getTotalOperationAccess().getPersonInitExpressionsCrossReference_1_0());
                    				

                    }


                    }
                    break;

            }

            // InternalSparrow.g:3157:3: (otherlv_2= 'G' ( (otherlv_3= RULE_ID ) ) )?
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==78) ) {
                alt49=1;
            }
            switch (alt49) {
                case 1 :
                    // InternalSparrow.g:3158:4: otherlv_2= 'G' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,78,FOLLOW_3); 

                    				newLeafNode(otherlv_2, grammarAccess.getTotalOperationAccess().getGKeyword_2_0());
                    			
                    // InternalSparrow.g:3162:4: ( (otherlv_3= RULE_ID ) )
                    // InternalSparrow.g:3163:5: (otherlv_3= RULE_ID )
                    {
                    // InternalSparrow.g:3163:5: (otherlv_3= RULE_ID )
                    // InternalSparrow.g:3164:6: otherlv_3= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTotalOperationRule());
                    						}
                    					
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_47); 

                    						newLeafNode(otherlv_3, grammarAccess.getTotalOperationAccess().getPerson2GroupCrossReference_2_1_0());
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalSparrow.g:3176:3: ( ( (lv_firstOperation_4_0= ruletrueOperation ) ) | ( (otherlv_5= RULE_ID ) ) )?
            int alt50=3;
            int LA50_0 = input.LA(1);

            if ( ((LA50_0>=105 && LA50_0<=107)||LA50_0==114) ) {
                alt50=1;
            }
            else if ( (LA50_0==RULE_ID) ) {
                int LA50_2 = input.LA(2);

                if ( (LA50_2==EOF||LA50_2==RULE_ID||LA50_2==19||LA50_2==23||(LA50_2>=68 && LA50_2<=69)||(LA50_2>=73 && LA50_2<=75)||(LA50_2>=79 && LA50_2<=81)||(LA50_2>=83 && LA50_2<=85)||LA50_2==87) ) {
                    alt50=2;
                }
            }
            switch (alt50) {
                case 1 :
                    // InternalSparrow.g:3177:4: ( (lv_firstOperation_4_0= ruletrueOperation ) )
                    {
                    // InternalSparrow.g:3177:4: ( (lv_firstOperation_4_0= ruletrueOperation ) )
                    // InternalSparrow.g:3178:5: (lv_firstOperation_4_0= ruletrueOperation )
                    {
                    // InternalSparrow.g:3178:5: (lv_firstOperation_4_0= ruletrueOperation )
                    // InternalSparrow.g:3179:6: lv_firstOperation_4_0= ruletrueOperation
                    {

                    						newCompositeNode(grammarAccess.getTotalOperationAccess().getFirstOperationTrueOperationParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_48);
                    lv_firstOperation_4_0=ruletrueOperation();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTotalOperationRule());
                    						}
                    						set(
                    							current,
                    							"firstOperation",
                    							lv_firstOperation_4_0,
                    							"org.xtext.example.mydsl.Sparrow.trueOperation");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSparrow.g:3197:4: ( (otherlv_5= RULE_ID ) )
                    {
                    // InternalSparrow.g:3197:4: ( (otherlv_5= RULE_ID ) )
                    // InternalSparrow.g:3198:5: (otherlv_5= RULE_ID )
                    {
                    // InternalSparrow.g:3198:5: (otherlv_5= RULE_ID )
                    // InternalSparrow.g:3199:6: otherlv_5= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTotalOperationRule());
                    						}
                    					
                    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_48); 

                    						newLeafNode(otherlv_5, grammarAccess.getTotalOperationAccess().getLinkOperationOperateLinkCrossReference_3_1_0());
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalSparrow.g:3211:3: ( (lv_andor_6_0= ruleAndOrOperationLink ) )*
            loop51:
            do {
                int alt51=2;
                int LA51_0 = input.LA(1);

                if ( (LA51_0==69) ) {
                    alt51=1;
                }


                switch (alt51) {
            	case 1 :
            	    // InternalSparrow.g:3212:4: (lv_andor_6_0= ruleAndOrOperationLink )
            	    {
            	    // InternalSparrow.g:3212:4: (lv_andor_6_0= ruleAndOrOperationLink )
            	    // InternalSparrow.g:3213:5: lv_andor_6_0= ruleAndOrOperationLink
            	    {

            	    					newCompositeNode(grammarAccess.getTotalOperationAccess().getAndorAndOrOperationLinkParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_48);
            	    lv_andor_6_0=ruleAndOrOperationLink();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTotalOperationRule());
            	    					}
            	    					add(
            	    						current,
            	    						"andor",
            	    						lv_andor_6_0,
            	    						"org.xtext.example.mydsl.Sparrow.AndOrOperationLink");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop51;
                }
            } while (true);

            // InternalSparrow.g:3230:3: ( (lv_timePoint_7_0= ruleTimepoint ) )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==85||LA52_0==87) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalSparrow.g:3231:4: (lv_timePoint_7_0= ruleTimepoint )
                    {
                    // InternalSparrow.g:3231:4: (lv_timePoint_7_0= ruleTimepoint )
                    // InternalSparrow.g:3232:5: lv_timePoint_7_0= ruleTimepoint
                    {

                    					newCompositeNode(grammarAccess.getTotalOperationAccess().getTimePointTimepointParserRuleCall_5_0());
                    				
                    pushFollow(FOLLOW_49);
                    lv_timePoint_7_0=ruleTimepoint();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getTotalOperationRule());
                    					}
                    					set(
                    						current,
                    						"timePoint",
                    						lv_timePoint_7_0,
                    						"org.xtext.example.mydsl.Sparrow.Timepoint");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalSparrow.g:3249:3: ( (lv_failresult_8_0= ruleFailResult ) )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==84) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // InternalSparrow.g:3250:4: (lv_failresult_8_0= ruleFailResult )
                    {
                    // InternalSparrow.g:3250:4: (lv_failresult_8_0= ruleFailResult )
                    // InternalSparrow.g:3251:5: lv_failresult_8_0= ruleFailResult
                    {

                    					newCompositeNode(grammarAccess.getTotalOperationAccess().getFailresultFailResultParserRuleCall_6_0());
                    				
                    pushFollow(FOLLOW_50);
                    lv_failresult_8_0=ruleFailResult();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getTotalOperationRule());
                    					}
                    					set(
                    						current,
                    						"failresult",
                    						lv_failresult_8_0,
                    						"org.xtext.example.mydsl.Sparrow.FailResult");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalSparrow.g:3268:3: ( (lv_thenoperation_9_0= ruleThenOperation ) )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==79) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // InternalSparrow.g:3269:4: (lv_thenoperation_9_0= ruleThenOperation )
            	    {
            	    // InternalSparrow.g:3269:4: (lv_thenoperation_9_0= ruleThenOperation )
            	    // InternalSparrow.g:3270:5: lv_thenoperation_9_0= ruleThenOperation
            	    {

            	    					newCompositeNode(grammarAccess.getTotalOperationAccess().getThenoperationThenOperationParserRuleCall_7_0());
            	    				
            	    pushFollow(FOLLOW_50);
            	    lv_thenoperation_9_0=ruleThenOperation();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getTotalOperationRule());
            	    					}
            	    					add(
            	    						current,
            	    						"thenoperation",
            	    						lv_thenoperation_9_0,
            	    						"org.xtext.example.mydsl.Sparrow.ThenOperation");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop54;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTotalOperation"


    // $ANTLR start "entryRuleAndOrOperationLink"
    // InternalSparrow.g:3291:1: entryRuleAndOrOperationLink returns [EObject current=null] : iv_ruleAndOrOperationLink= ruleAndOrOperationLink EOF ;
    public final EObject entryRuleAndOrOperationLink() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndOrOperationLink = null;


        try {
            // InternalSparrow.g:3291:59: (iv_ruleAndOrOperationLink= ruleAndOrOperationLink EOF )
            // InternalSparrow.g:3292:2: iv_ruleAndOrOperationLink= ruleAndOrOperationLink EOF
            {
             newCompositeNode(grammarAccess.getAndOrOperationLinkRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAndOrOperationLink=ruleAndOrOperationLink();

            state._fsp--;

             current =iv_ruleAndOrOperationLink; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAndOrOperationLink"


    // $ANTLR start "ruleAndOrOperationLink"
    // InternalSparrow.g:3298:1: ruleAndOrOperationLink returns [EObject current=null] : ( ( (lv_link_0_0= 'and' ) ) ( ( (lv_firstOperation_1_0= ruletrueOperation ) ) | ( (otherlv_2= RULE_ID ) ) ) ) ;
    public final EObject ruleAndOrOperationLink() throws RecognitionException {
        EObject current = null;

        Token lv_link_0_0=null;
        Token otherlv_2=null;
        EObject lv_firstOperation_1_0 = null;



        	enterRule();

        try {
            // InternalSparrow.g:3304:2: ( ( ( (lv_link_0_0= 'and' ) ) ( ( (lv_firstOperation_1_0= ruletrueOperation ) ) | ( (otherlv_2= RULE_ID ) ) ) ) )
            // InternalSparrow.g:3305:2: ( ( (lv_link_0_0= 'and' ) ) ( ( (lv_firstOperation_1_0= ruletrueOperation ) ) | ( (otherlv_2= RULE_ID ) ) ) )
            {
            // InternalSparrow.g:3305:2: ( ( (lv_link_0_0= 'and' ) ) ( ( (lv_firstOperation_1_0= ruletrueOperation ) ) | ( (otherlv_2= RULE_ID ) ) ) )
            // InternalSparrow.g:3306:3: ( (lv_link_0_0= 'and' ) ) ( ( (lv_firstOperation_1_0= ruletrueOperation ) ) | ( (otherlv_2= RULE_ID ) ) )
            {
            // InternalSparrow.g:3306:3: ( (lv_link_0_0= 'and' ) )
            // InternalSparrow.g:3307:4: (lv_link_0_0= 'and' )
            {
            // InternalSparrow.g:3307:4: (lv_link_0_0= 'and' )
            // InternalSparrow.g:3308:5: lv_link_0_0= 'and'
            {
            lv_link_0_0=(Token)match(input,69,FOLLOW_38); 

            					newLeafNode(lv_link_0_0, grammarAccess.getAndOrOperationLinkAccess().getLinkAndKeyword_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getAndOrOperationLinkRule());
            					}
            					setWithLastConsumed(current, "link", lv_link_0_0, "and");
            				

            }


            }

            // InternalSparrow.g:3320:3: ( ( (lv_firstOperation_1_0= ruletrueOperation ) ) | ( (otherlv_2= RULE_ID ) ) )
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( ((LA55_0>=105 && LA55_0<=107)||LA55_0==114) ) {
                alt55=1;
            }
            else if ( (LA55_0==RULE_ID) ) {
                alt55=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 55, 0, input);

                throw nvae;
            }
            switch (alt55) {
                case 1 :
                    // InternalSparrow.g:3321:4: ( (lv_firstOperation_1_0= ruletrueOperation ) )
                    {
                    // InternalSparrow.g:3321:4: ( (lv_firstOperation_1_0= ruletrueOperation ) )
                    // InternalSparrow.g:3322:5: (lv_firstOperation_1_0= ruletrueOperation )
                    {
                    // InternalSparrow.g:3322:5: (lv_firstOperation_1_0= ruletrueOperation )
                    // InternalSparrow.g:3323:6: lv_firstOperation_1_0= ruletrueOperation
                    {

                    						newCompositeNode(grammarAccess.getAndOrOperationLinkAccess().getFirstOperationTrueOperationParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_firstOperation_1_0=ruletrueOperation();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAndOrOperationLinkRule());
                    						}
                    						set(
                    							current,
                    							"firstOperation",
                    							lv_firstOperation_1_0,
                    							"org.xtext.example.mydsl.Sparrow.trueOperation");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSparrow.g:3341:4: ( (otherlv_2= RULE_ID ) )
                    {
                    // InternalSparrow.g:3341:4: ( (otherlv_2= RULE_ID ) )
                    // InternalSparrow.g:3342:5: (otherlv_2= RULE_ID )
                    {
                    // InternalSparrow.g:3342:5: (otherlv_2= RULE_ID )
                    // InternalSparrow.g:3343:6: otherlv_2= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getAndOrOperationLinkRule());
                    						}
                    					
                    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_2); 

                    						newLeafNode(otherlv_2, grammarAccess.getAndOrOperationLinkAccess().getLinkOperationOperateLinkCrossReference_1_1_0());
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAndOrOperationLink"


    // $ANTLR start "entryRuleThenOperation"
    // InternalSparrow.g:3359:1: entryRuleThenOperation returns [EObject current=null] : iv_ruleThenOperation= ruleThenOperation EOF ;
    public final EObject entryRuleThenOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleThenOperation = null;


        try {
            // InternalSparrow.g:3359:54: (iv_ruleThenOperation= ruleThenOperation EOF )
            // InternalSparrow.g:3360:2: iv_ruleThenOperation= ruleThenOperation EOF
            {
             newCompositeNode(grammarAccess.getThenOperationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleThenOperation=ruleThenOperation();

            state._fsp--;

             current =iv_ruleThenOperation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleThenOperation"


    // $ANTLR start "ruleThenOperation"
    // InternalSparrow.g:3366:1: ruleThenOperation returns [EObject current=null] : (otherlv_0= 'Then' ( ( (lv_followingOperation_1_0= ruletrueOperation ) ) | ( (otherlv_2= RULE_ID ) ) ) ( (lv_andor_3_0= ruleAndOrOperationLink ) )* ( (lv_timePoint_4_0= ruleTimepoint ) )? ( (lv_failresult_5_0= ruleFailResult ) )? ) ;
    public final EObject ruleThenOperation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_followingOperation_1_0 = null;

        EObject lv_andor_3_0 = null;

        EObject lv_timePoint_4_0 = null;

        EObject lv_failresult_5_0 = null;



        	enterRule();

        try {
            // InternalSparrow.g:3372:2: ( (otherlv_0= 'Then' ( ( (lv_followingOperation_1_0= ruletrueOperation ) ) | ( (otherlv_2= RULE_ID ) ) ) ( (lv_andor_3_0= ruleAndOrOperationLink ) )* ( (lv_timePoint_4_0= ruleTimepoint ) )? ( (lv_failresult_5_0= ruleFailResult ) )? ) )
            // InternalSparrow.g:3373:2: (otherlv_0= 'Then' ( ( (lv_followingOperation_1_0= ruletrueOperation ) ) | ( (otherlv_2= RULE_ID ) ) ) ( (lv_andor_3_0= ruleAndOrOperationLink ) )* ( (lv_timePoint_4_0= ruleTimepoint ) )? ( (lv_failresult_5_0= ruleFailResult ) )? )
            {
            // InternalSparrow.g:3373:2: (otherlv_0= 'Then' ( ( (lv_followingOperation_1_0= ruletrueOperation ) ) | ( (otherlv_2= RULE_ID ) ) ) ( (lv_andor_3_0= ruleAndOrOperationLink ) )* ( (lv_timePoint_4_0= ruleTimepoint ) )? ( (lv_failresult_5_0= ruleFailResult ) )? )
            // InternalSparrow.g:3374:3: otherlv_0= 'Then' ( ( (lv_followingOperation_1_0= ruletrueOperation ) ) | ( (otherlv_2= RULE_ID ) ) ) ( (lv_andor_3_0= ruleAndOrOperationLink ) )* ( (lv_timePoint_4_0= ruleTimepoint ) )? ( (lv_failresult_5_0= ruleFailResult ) )?
            {
            otherlv_0=(Token)match(input,79,FOLLOW_38); 

            			newLeafNode(otherlv_0, grammarAccess.getThenOperationAccess().getThenKeyword_0());
            		
            // InternalSparrow.g:3378:3: ( ( (lv_followingOperation_1_0= ruletrueOperation ) ) | ( (otherlv_2= RULE_ID ) ) )
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( ((LA56_0>=105 && LA56_0<=107)||LA56_0==114) ) {
                alt56=1;
            }
            else if ( (LA56_0==RULE_ID) ) {
                alt56=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 56, 0, input);

                throw nvae;
            }
            switch (alt56) {
                case 1 :
                    // InternalSparrow.g:3379:4: ( (lv_followingOperation_1_0= ruletrueOperation ) )
                    {
                    // InternalSparrow.g:3379:4: ( (lv_followingOperation_1_0= ruletrueOperation ) )
                    // InternalSparrow.g:3380:5: (lv_followingOperation_1_0= ruletrueOperation )
                    {
                    // InternalSparrow.g:3380:5: (lv_followingOperation_1_0= ruletrueOperation )
                    // InternalSparrow.g:3381:6: lv_followingOperation_1_0= ruletrueOperation
                    {

                    						newCompositeNode(grammarAccess.getThenOperationAccess().getFollowingOperationTrueOperationParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_51);
                    lv_followingOperation_1_0=ruletrueOperation();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getThenOperationRule());
                    						}
                    						set(
                    							current,
                    							"followingOperation",
                    							lv_followingOperation_1_0,
                    							"org.xtext.example.mydsl.Sparrow.trueOperation");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSparrow.g:3399:4: ( (otherlv_2= RULE_ID ) )
                    {
                    // InternalSparrow.g:3399:4: ( (otherlv_2= RULE_ID ) )
                    // InternalSparrow.g:3400:5: (otherlv_2= RULE_ID )
                    {
                    // InternalSparrow.g:3400:5: (otherlv_2= RULE_ID )
                    // InternalSparrow.g:3401:6: otherlv_2= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getThenOperationRule());
                    						}
                    					
                    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_51); 

                    						newLeafNode(otherlv_2, grammarAccess.getThenOperationAccess().getLinkOperationOperateLinkCrossReference_1_1_0());
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalSparrow.g:3413:3: ( (lv_andor_3_0= ruleAndOrOperationLink ) )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==69) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // InternalSparrow.g:3414:4: (lv_andor_3_0= ruleAndOrOperationLink )
            	    {
            	    // InternalSparrow.g:3414:4: (lv_andor_3_0= ruleAndOrOperationLink )
            	    // InternalSparrow.g:3415:5: lv_andor_3_0= ruleAndOrOperationLink
            	    {

            	    					newCompositeNode(grammarAccess.getThenOperationAccess().getAndorAndOrOperationLinkParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_51);
            	    lv_andor_3_0=ruleAndOrOperationLink();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getThenOperationRule());
            	    					}
            	    					add(
            	    						current,
            	    						"andor",
            	    						lv_andor_3_0,
            	    						"org.xtext.example.mydsl.Sparrow.AndOrOperationLink");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop57;
                }
            } while (true);

            // InternalSparrow.g:3432:3: ( (lv_timePoint_4_0= ruleTimepoint ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==85||LA58_0==87) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // InternalSparrow.g:3433:4: (lv_timePoint_4_0= ruleTimepoint )
                    {
                    // InternalSparrow.g:3433:4: (lv_timePoint_4_0= ruleTimepoint )
                    // InternalSparrow.g:3434:5: lv_timePoint_4_0= ruleTimepoint
                    {

                    					newCompositeNode(grammarAccess.getThenOperationAccess().getTimePointTimepointParserRuleCall_3_0());
                    				
                    pushFollow(FOLLOW_52);
                    lv_timePoint_4_0=ruleTimepoint();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getThenOperationRule());
                    					}
                    					set(
                    						current,
                    						"timePoint",
                    						lv_timePoint_4_0,
                    						"org.xtext.example.mydsl.Sparrow.Timepoint");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalSparrow.g:3451:3: ( (lv_failresult_5_0= ruleFailResult ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==84) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalSparrow.g:3452:4: (lv_failresult_5_0= ruleFailResult )
                    {
                    // InternalSparrow.g:3452:4: (lv_failresult_5_0= ruleFailResult )
                    // InternalSparrow.g:3453:5: lv_failresult_5_0= ruleFailResult
                    {

                    					newCompositeNode(grammarAccess.getThenOperationAccess().getFailresultFailResultParserRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_failresult_5_0=ruleFailResult();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getThenOperationRule());
                    					}
                    					set(
                    						current,
                    						"failresult",
                    						lv_failresult_5_0,
                    						"org.xtext.example.mydsl.Sparrow.FailResult");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleThenOperation"


    // $ANTLR start "entryRuleTotalExpression"
    // InternalSparrow.g:3474:1: entryRuleTotalExpression returns [EObject current=null] : iv_ruleTotalExpression= ruleTotalExpression EOF ;
    public final EObject entryRuleTotalExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTotalExpression = null;


        try {
            // InternalSparrow.g:3474:56: (iv_ruleTotalExpression= ruleTotalExpression EOF )
            // InternalSparrow.g:3475:2: iv_ruleTotalExpression= ruleTotalExpression EOF
            {
             newCompositeNode(grammarAccess.getTotalExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTotalExpression=ruleTotalExpression();

            state._fsp--;

             current =iv_ruleTotalExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTotalExpression"


    // $ANTLR start "ruleTotalExpression"
    // InternalSparrow.g:3481:1: ruleTotalExpression returns [EObject current=null] : ( ( (lv_set_0_0= rulemessageExpression ) )? ( (lv_totalCondition_1_0= ruleTotalCondition ) )? ( (lv_totalOperation_2_0= ruleTotalOperation ) ) ( (lv_elseExpression_3_0= ruleElseExpression ) )? ) ;
    public final EObject ruleTotalExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_set_0_0 = null;

        EObject lv_totalCondition_1_0 = null;

        EObject lv_totalOperation_2_0 = null;

        EObject lv_elseExpression_3_0 = null;



        	enterRule();

        try {
            // InternalSparrow.g:3487:2: ( ( ( (lv_set_0_0= rulemessageExpression ) )? ( (lv_totalCondition_1_0= ruleTotalCondition ) )? ( (lv_totalOperation_2_0= ruleTotalOperation ) ) ( (lv_elseExpression_3_0= ruleElseExpression ) )? ) )
            // InternalSparrow.g:3488:2: ( ( (lv_set_0_0= rulemessageExpression ) )? ( (lv_totalCondition_1_0= ruleTotalCondition ) )? ( (lv_totalOperation_2_0= ruleTotalOperation ) ) ( (lv_elseExpression_3_0= ruleElseExpression ) )? )
            {
            // InternalSparrow.g:3488:2: ( ( (lv_set_0_0= rulemessageExpression ) )? ( (lv_totalCondition_1_0= ruleTotalCondition ) )? ( (lv_totalOperation_2_0= ruleTotalOperation ) ) ( (lv_elseExpression_3_0= ruleElseExpression ) )? )
            // InternalSparrow.g:3489:3: ( (lv_set_0_0= rulemessageExpression ) )? ( (lv_totalCondition_1_0= ruleTotalCondition ) )? ( (lv_totalOperation_2_0= ruleTotalOperation ) ) ( (lv_elseExpression_3_0= ruleElseExpression ) )?
            {
            // InternalSparrow.g:3489:3: ( (lv_set_0_0= rulemessageExpression ) )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==103) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // InternalSparrow.g:3490:4: (lv_set_0_0= rulemessageExpression )
                    {
                    // InternalSparrow.g:3490:4: (lv_set_0_0= rulemessageExpression )
                    // InternalSparrow.g:3491:5: lv_set_0_0= rulemessageExpression
                    {

                    					newCompositeNode(grammarAccess.getTotalExpressionAccess().getSetMessageExpressionParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_53);
                    lv_set_0_0=rulemessageExpression();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getTotalExpressionRule());
                    					}
                    					set(
                    						current,
                    						"set",
                    						lv_set_0_0,
                    						"org.xtext.example.mydsl.Sparrow.messageExpression");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalSparrow.g:3508:3: ( (lv_totalCondition_1_0= ruleTotalCondition ) )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==76) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // InternalSparrow.g:3509:4: (lv_totalCondition_1_0= ruleTotalCondition )
                    {
                    // InternalSparrow.g:3509:4: (lv_totalCondition_1_0= ruleTotalCondition )
                    // InternalSparrow.g:3510:5: lv_totalCondition_1_0= ruleTotalCondition
                    {

                    					newCompositeNode(grammarAccess.getTotalExpressionAccess().getTotalConditionTotalConditionParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_54);
                    lv_totalCondition_1_0=ruleTotalCondition();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getTotalExpressionRule());
                    					}
                    					set(
                    						current,
                    						"totalCondition",
                    						lv_totalCondition_1_0,
                    						"org.xtext.example.mydsl.Sparrow.TotalCondition");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalSparrow.g:3527:3: ( (lv_totalOperation_2_0= ruleTotalOperation ) )
            // InternalSparrow.g:3528:4: (lv_totalOperation_2_0= ruleTotalOperation )
            {
            // InternalSparrow.g:3528:4: (lv_totalOperation_2_0= ruleTotalOperation )
            // InternalSparrow.g:3529:5: lv_totalOperation_2_0= ruleTotalOperation
            {

            					newCompositeNode(grammarAccess.getTotalExpressionAccess().getTotalOperationTotalOperationParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_55);
            lv_totalOperation_2_0=ruleTotalOperation();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTotalExpressionRule());
            					}
            					set(
            						current,
            						"totalOperation",
            						lv_totalOperation_2_0,
            						"org.xtext.example.mydsl.Sparrow.TotalOperation");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSparrow.g:3546:3: ( (lv_elseExpression_3_0= ruleElseExpression ) )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==80) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // InternalSparrow.g:3547:4: (lv_elseExpression_3_0= ruleElseExpression )
                    {
                    // InternalSparrow.g:3547:4: (lv_elseExpression_3_0= ruleElseExpression )
                    // InternalSparrow.g:3548:5: lv_elseExpression_3_0= ruleElseExpression
                    {

                    					newCompositeNode(grammarAccess.getTotalExpressionAccess().getElseExpressionElseExpressionParserRuleCall_3_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_elseExpression_3_0=ruleElseExpression();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getTotalExpressionRule());
                    					}
                    					set(
                    						current,
                    						"elseExpression",
                    						lv_elseExpression_3_0,
                    						"org.xtext.example.mydsl.Sparrow.ElseExpression");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTotalExpression"


    // $ANTLR start "entryRuleElseExpression"
    // InternalSparrow.g:3569:1: entryRuleElseExpression returns [EObject current=null] : iv_ruleElseExpression= ruleElseExpression EOF ;
    public final EObject entryRuleElseExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElseExpression = null;


        try {
            // InternalSparrow.g:3569:55: (iv_ruleElseExpression= ruleElseExpression EOF )
            // InternalSparrow.g:3570:2: iv_ruleElseExpression= ruleElseExpression EOF
            {
             newCompositeNode(grammarAccess.getElseExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleElseExpression=ruleElseExpression();

            state._fsp--;

             current =iv_ruleElseExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleElseExpression"


    // $ANTLR start "ruleElseExpression"
    // InternalSparrow.g:3576:1: ruleElseExpression returns [EObject current=null] : (otherlv_0= 'Else' ( (lv_set_1_0= rulemessageExpression ) )? ( (lv_totalCondition_2_0= ruleTotalCondition ) )? ( (lv_totalOperation_3_0= ruleTotalOperation ) ) ) ;
    public final EObject ruleElseExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_set_1_0 = null;

        EObject lv_totalCondition_2_0 = null;

        EObject lv_totalOperation_3_0 = null;



        	enterRule();

        try {
            // InternalSparrow.g:3582:2: ( (otherlv_0= 'Else' ( (lv_set_1_0= rulemessageExpression ) )? ( (lv_totalCondition_2_0= ruleTotalCondition ) )? ( (lv_totalOperation_3_0= ruleTotalOperation ) ) ) )
            // InternalSparrow.g:3583:2: (otherlv_0= 'Else' ( (lv_set_1_0= rulemessageExpression ) )? ( (lv_totalCondition_2_0= ruleTotalCondition ) )? ( (lv_totalOperation_3_0= ruleTotalOperation ) ) )
            {
            // InternalSparrow.g:3583:2: (otherlv_0= 'Else' ( (lv_set_1_0= rulemessageExpression ) )? ( (lv_totalCondition_2_0= ruleTotalCondition ) )? ( (lv_totalOperation_3_0= ruleTotalOperation ) ) )
            // InternalSparrow.g:3584:3: otherlv_0= 'Else' ( (lv_set_1_0= rulemessageExpression ) )? ( (lv_totalCondition_2_0= ruleTotalCondition ) )? ( (lv_totalOperation_3_0= ruleTotalOperation ) )
            {
            otherlv_0=(Token)match(input,80,FOLLOW_56); 

            			newLeafNode(otherlv_0, grammarAccess.getElseExpressionAccess().getElseKeyword_0());
            		
            // InternalSparrow.g:3588:3: ( (lv_set_1_0= rulemessageExpression ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==103) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalSparrow.g:3589:4: (lv_set_1_0= rulemessageExpression )
                    {
                    // InternalSparrow.g:3589:4: (lv_set_1_0= rulemessageExpression )
                    // InternalSparrow.g:3590:5: lv_set_1_0= rulemessageExpression
                    {

                    					newCompositeNode(grammarAccess.getElseExpressionAccess().getSetMessageExpressionParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_57);
                    lv_set_1_0=rulemessageExpression();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getElseExpressionRule());
                    					}
                    					set(
                    						current,
                    						"set",
                    						lv_set_1_0,
                    						"org.xtext.example.mydsl.Sparrow.messageExpression");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalSparrow.g:3607:3: ( (lv_totalCondition_2_0= ruleTotalCondition ) )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==76) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // InternalSparrow.g:3608:4: (lv_totalCondition_2_0= ruleTotalCondition )
                    {
                    // InternalSparrow.g:3608:4: (lv_totalCondition_2_0= ruleTotalCondition )
                    // InternalSparrow.g:3609:5: lv_totalCondition_2_0= ruleTotalCondition
                    {

                    					newCompositeNode(grammarAccess.getElseExpressionAccess().getTotalConditionTotalConditionParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_58);
                    lv_totalCondition_2_0=ruleTotalCondition();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getElseExpressionRule());
                    					}
                    					set(
                    						current,
                    						"totalCondition",
                    						lv_totalCondition_2_0,
                    						"org.xtext.example.mydsl.Sparrow.TotalCondition");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalSparrow.g:3626:3: ( (lv_totalOperation_3_0= ruleTotalOperation ) )
            // InternalSparrow.g:3627:4: (lv_totalOperation_3_0= ruleTotalOperation )
            {
            // InternalSparrow.g:3627:4: (lv_totalOperation_3_0= ruleTotalOperation )
            // InternalSparrow.g:3628:5: lv_totalOperation_3_0= ruleTotalOperation
            {

            					newCompositeNode(grammarAccess.getElseExpressionAccess().getTotalOperationTotalOperationParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_totalOperation_3_0=ruleTotalOperation();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getElseExpressionRule());
            					}
            					set(
            						current,
            						"totalOperation",
            						lv_totalOperation_3_0,
            						"org.xtext.example.mydsl.Sparrow.TotalOperation");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleElseExpression"


    // $ANTLR start "entryRuleRuleExpression"
    // InternalSparrow.g:3649:1: entryRuleRuleExpression returns [EObject current=null] : iv_ruleRuleExpression= ruleRuleExpression EOF ;
    public final EObject entryRuleRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleExpression = null;


        try {
            // InternalSparrow.g:3649:55: (iv_ruleRuleExpression= ruleRuleExpression EOF )
            // InternalSparrow.g:3650:2: iv_ruleRuleExpression= ruleRuleExpression EOF
            {
             newCompositeNode(grammarAccess.getRuleExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRuleExpression=ruleRuleExpression();

            state._fsp--;

             current =iv_ruleRuleExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRuleExpression"


    // $ANTLR start "ruleRuleExpression"
    // InternalSparrow.g:3656:1: ruleRuleExpression returns [EObject current=null] : ( ( (lv_repeat_0_0= 'Repeat' ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_set_3_0= rulemessageExpression ) )? ( (lv_setdate_4_0= rulesetDateExpression ) )? ( (lv_totalCondition_5_0= ruleTotalCondition ) )? ( (lv_totalOperation_6_0= ruleTotalOperation ) ) ( (lv_subExpression_7_0= ruleSubExpression ) )* ( (lv_elseExpression_8_0= ruleElseExpression ) )? ) ;
    public final EObject ruleRuleExpression() throws RecognitionException {
        EObject current = null;

        Token lv_repeat_0_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_set_3_0 = null;

        EObject lv_setdate_4_0 = null;

        EObject lv_totalCondition_5_0 = null;

        EObject lv_totalOperation_6_0 = null;

        EObject lv_subExpression_7_0 = null;

        EObject lv_elseExpression_8_0 = null;



        	enterRule();

        try {
            // InternalSparrow.g:3662:2: ( ( ( (lv_repeat_0_0= 'Repeat' ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_set_3_0= rulemessageExpression ) )? ( (lv_setdate_4_0= rulesetDateExpression ) )? ( (lv_totalCondition_5_0= ruleTotalCondition ) )? ( (lv_totalOperation_6_0= ruleTotalOperation ) ) ( (lv_subExpression_7_0= ruleSubExpression ) )* ( (lv_elseExpression_8_0= ruleElseExpression ) )? ) )
            // InternalSparrow.g:3663:2: ( ( (lv_repeat_0_0= 'Repeat' ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_set_3_0= rulemessageExpression ) )? ( (lv_setdate_4_0= rulesetDateExpression ) )? ( (lv_totalCondition_5_0= ruleTotalCondition ) )? ( (lv_totalOperation_6_0= ruleTotalOperation ) ) ( (lv_subExpression_7_0= ruleSubExpression ) )* ( (lv_elseExpression_8_0= ruleElseExpression ) )? )
            {
            // InternalSparrow.g:3663:2: ( ( (lv_repeat_0_0= 'Repeat' ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_set_3_0= rulemessageExpression ) )? ( (lv_setdate_4_0= rulesetDateExpression ) )? ( (lv_totalCondition_5_0= ruleTotalCondition ) )? ( (lv_totalOperation_6_0= ruleTotalOperation ) ) ( (lv_subExpression_7_0= ruleSubExpression ) )* ( (lv_elseExpression_8_0= ruleElseExpression ) )? )
            // InternalSparrow.g:3664:3: ( (lv_repeat_0_0= 'Repeat' ) )? ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_set_3_0= rulemessageExpression ) )? ( (lv_setdate_4_0= rulesetDateExpression ) )? ( (lv_totalCondition_5_0= ruleTotalCondition ) )? ( (lv_totalOperation_6_0= ruleTotalOperation ) ) ( (lv_subExpression_7_0= ruleSubExpression ) )* ( (lv_elseExpression_8_0= ruleElseExpression ) )?
            {
            // InternalSparrow.g:3664:3: ( (lv_repeat_0_0= 'Repeat' ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==81) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalSparrow.g:3665:4: (lv_repeat_0_0= 'Repeat' )
                    {
                    // InternalSparrow.g:3665:4: (lv_repeat_0_0= 'Repeat' )
                    // InternalSparrow.g:3666:5: lv_repeat_0_0= 'Repeat'
                    {
                    lv_repeat_0_0=(Token)match(input,81,FOLLOW_3); 

                    					newLeafNode(lv_repeat_0_0, grammarAccess.getRuleExpressionAccess().getRepeatRepeatKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getRuleExpressionRule());
                    					}
                    					setWithLastConsumed(current, "repeat", lv_repeat_0_0, "Repeat");
                    				

                    }


                    }
                    break;

            }

            // InternalSparrow.g:3678:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalSparrow.g:3679:4: (lv_name_1_0= RULE_ID )
            {
            // InternalSparrow.g:3679:4: (lv_name_1_0= RULE_ID )
            // InternalSparrow.g:3680:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_16); 

            					newLeafNode(lv_name_1_0, grammarAccess.getRuleExpressionAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRuleExpressionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,21,FOLLOW_59); 

            			newLeafNode(otherlv_2, grammarAccess.getRuleExpressionAccess().getColonKeyword_2());
            		
            // InternalSparrow.g:3700:3: ( (lv_set_3_0= rulemessageExpression ) )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==103) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // InternalSparrow.g:3701:4: (lv_set_3_0= rulemessageExpression )
                    {
                    // InternalSparrow.g:3701:4: (lv_set_3_0= rulemessageExpression )
                    // InternalSparrow.g:3702:5: lv_set_3_0= rulemessageExpression
                    {

                    					newCompositeNode(grammarAccess.getRuleExpressionAccess().getSetMessageExpressionParserRuleCall_3_0());
                    				
                    pushFollow(FOLLOW_60);
                    lv_set_3_0=rulemessageExpression();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getRuleExpressionRule());
                    					}
                    					set(
                    						current,
                    						"set",
                    						lv_set_3_0,
                    						"org.xtext.example.mydsl.Sparrow.messageExpression");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalSparrow.g:3719:3: ( (lv_setdate_4_0= rulesetDateExpression ) )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==82) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalSparrow.g:3720:4: (lv_setdate_4_0= rulesetDateExpression )
                    {
                    // InternalSparrow.g:3720:4: (lv_setdate_4_0= rulesetDateExpression )
                    // InternalSparrow.g:3721:5: lv_setdate_4_0= rulesetDateExpression
                    {

                    					newCompositeNode(grammarAccess.getRuleExpressionAccess().getSetdateSetDateExpressionParserRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_61);
                    lv_setdate_4_0=rulesetDateExpression();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getRuleExpressionRule());
                    					}
                    					set(
                    						current,
                    						"setdate",
                    						lv_setdate_4_0,
                    						"org.xtext.example.mydsl.Sparrow.setDateExpression");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalSparrow.g:3738:3: ( (lv_totalCondition_5_0= ruleTotalCondition ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==76) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // InternalSparrow.g:3739:4: (lv_totalCondition_5_0= ruleTotalCondition )
                    {
                    // InternalSparrow.g:3739:4: (lv_totalCondition_5_0= ruleTotalCondition )
                    // InternalSparrow.g:3740:5: lv_totalCondition_5_0= ruleTotalCondition
                    {

                    					newCompositeNode(grammarAccess.getRuleExpressionAccess().getTotalConditionTotalConditionParserRuleCall_5_0());
                    				
                    pushFollow(FOLLOW_62);
                    lv_totalCondition_5_0=ruleTotalCondition();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getRuleExpressionRule());
                    					}
                    					set(
                    						current,
                    						"totalCondition",
                    						lv_totalCondition_5_0,
                    						"org.xtext.example.mydsl.Sparrow.TotalCondition");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalSparrow.g:3757:3: ( (lv_totalOperation_6_0= ruleTotalOperation ) )
            // InternalSparrow.g:3758:4: (lv_totalOperation_6_0= ruleTotalOperation )
            {
            // InternalSparrow.g:3758:4: (lv_totalOperation_6_0= ruleTotalOperation )
            // InternalSparrow.g:3759:5: lv_totalOperation_6_0= ruleTotalOperation
            {

            					newCompositeNode(grammarAccess.getRuleExpressionAccess().getTotalOperationTotalOperationParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_63);
            lv_totalOperation_6_0=ruleTotalOperation();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRuleExpressionRule());
            					}
            					set(
            						current,
            						"totalOperation",
            						lv_totalOperation_6_0,
            						"org.xtext.example.mydsl.Sparrow.TotalOperation");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSparrow.g:3776:3: ( (lv_subExpression_7_0= ruleSubExpression ) )*
            loop69:
            do {
                int alt69=2;
                int LA69_0 = input.LA(1);

                if ( (LA69_0==83) ) {
                    alt69=1;
                }


                switch (alt69) {
            	case 1 :
            	    // InternalSparrow.g:3777:4: (lv_subExpression_7_0= ruleSubExpression )
            	    {
            	    // InternalSparrow.g:3777:4: (lv_subExpression_7_0= ruleSubExpression )
            	    // InternalSparrow.g:3778:5: lv_subExpression_7_0= ruleSubExpression
            	    {

            	    					newCompositeNode(grammarAccess.getRuleExpressionAccess().getSubExpressionSubExpressionParserRuleCall_7_0());
            	    				
            	    pushFollow(FOLLOW_63);
            	    lv_subExpression_7_0=ruleSubExpression();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getRuleExpressionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"subExpression",
            	    						lv_subExpression_7_0,
            	    						"org.xtext.example.mydsl.Sparrow.SubExpression");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop69;
                }
            } while (true);

            // InternalSparrow.g:3795:3: ( (lv_elseExpression_8_0= ruleElseExpression ) )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==80) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // InternalSparrow.g:3796:4: (lv_elseExpression_8_0= ruleElseExpression )
                    {
                    // InternalSparrow.g:3796:4: (lv_elseExpression_8_0= ruleElseExpression )
                    // InternalSparrow.g:3797:5: lv_elseExpression_8_0= ruleElseExpression
                    {

                    					newCompositeNode(grammarAccess.getRuleExpressionAccess().getElseExpressionElseExpressionParserRuleCall_8_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_elseExpression_8_0=ruleElseExpression();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getRuleExpressionRule());
                    					}
                    					set(
                    						current,
                    						"elseExpression",
                    						lv_elseExpression_8_0,
                    						"org.xtext.example.mydsl.Sparrow.ElseExpression");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRuleExpression"


    // $ANTLR start "entryRulesetDateExpression"
    // InternalSparrow.g:3818:1: entryRulesetDateExpression returns [EObject current=null] : iv_rulesetDateExpression= rulesetDateExpression EOF ;
    public final EObject entryRulesetDateExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulesetDateExpression = null;


        try {
            // InternalSparrow.g:3818:58: (iv_rulesetDateExpression= rulesetDateExpression EOF )
            // InternalSparrow.g:3819:2: iv_rulesetDateExpression= rulesetDateExpression EOF
            {
             newCompositeNode(grammarAccess.getSetDateExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_rulesetDateExpression=rulesetDateExpression();

            state._fsp--;

             current =iv_rulesetDateExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulesetDateExpression"


    // $ANTLR start "rulesetDateExpression"
    // InternalSparrow.g:3825:1: rulesetDateExpression returns [EObject current=null] : (otherlv_0= 'SetDate(' ( (lv_message_1_0= RULE_ID ) ) otherlv_2= ')' ) ;
    public final EObject rulesetDateExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_message_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSparrow.g:3831:2: ( (otherlv_0= 'SetDate(' ( (lv_message_1_0= RULE_ID ) ) otherlv_2= ')' ) )
            // InternalSparrow.g:3832:2: (otherlv_0= 'SetDate(' ( (lv_message_1_0= RULE_ID ) ) otherlv_2= ')' )
            {
            // InternalSparrow.g:3832:2: (otherlv_0= 'SetDate(' ( (lv_message_1_0= RULE_ID ) ) otherlv_2= ')' )
            // InternalSparrow.g:3833:3: otherlv_0= 'SetDate(' ( (lv_message_1_0= RULE_ID ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,82,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getSetDateExpressionAccess().getSetDateKeyword_0());
            		
            // InternalSparrow.g:3837:3: ( (lv_message_1_0= RULE_ID ) )
            // InternalSparrow.g:3838:4: (lv_message_1_0= RULE_ID )
            {
            // InternalSparrow.g:3838:4: (lv_message_1_0= RULE_ID )
            // InternalSparrow.g:3839:5: lv_message_1_0= RULE_ID
            {
            lv_message_1_0=(Token)match(input,RULE_ID,FOLLOW_64); 

            					newLeafNode(lv_message_1_0, grammarAccess.getSetDateExpressionAccess().getMessageIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSetDateExpressionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"message",
            						lv_message_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,39,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getSetDateExpressionAccess().getRightParenthesisKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulesetDateExpression"


    // $ANTLR start "entryRuleSubExpression"
    // InternalSparrow.g:3863:1: entryRuleSubExpression returns [EObject current=null] : iv_ruleSubExpression= ruleSubExpression EOF ;
    public final EObject entryRuleSubExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubExpression = null;


        try {
            // InternalSparrow.g:3863:54: (iv_ruleSubExpression= ruleSubExpression EOF )
            // InternalSparrow.g:3864:2: iv_ruleSubExpression= ruleSubExpression EOF
            {
             newCompositeNode(grammarAccess.getSubExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSubExpression=ruleSubExpression();

            state._fsp--;

             current =iv_ruleSubExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSubExpression"


    // $ANTLR start "ruleSubExpression"
    // InternalSparrow.g:3870:1: ruleSubExpression returns [EObject current=null] : (otherlv_0= 'SubRule' otherlv_1= '{' ( (lv_totalExpression_2_0= ruleTotalExpression ) ) otherlv_3= '}' ) ;
    public final EObject ruleSubExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_totalExpression_2_0 = null;



        	enterRule();

        try {
            // InternalSparrow.g:3876:2: ( (otherlv_0= 'SubRule' otherlv_1= '{' ( (lv_totalExpression_2_0= ruleTotalExpression ) ) otherlv_3= '}' ) )
            // InternalSparrow.g:3877:2: (otherlv_0= 'SubRule' otherlv_1= '{' ( (lv_totalExpression_2_0= ruleTotalExpression ) ) otherlv_3= '}' )
            {
            // InternalSparrow.g:3877:2: (otherlv_0= 'SubRule' otherlv_1= '{' ( (lv_totalExpression_2_0= ruleTotalExpression ) ) otherlv_3= '}' )
            // InternalSparrow.g:3878:3: otherlv_0= 'SubRule' otherlv_1= '{' ( (lv_totalExpression_2_0= ruleTotalExpression ) ) otherlv_3= '}'
            {
            otherlv_0=(Token)match(input,83,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getSubExpressionAccess().getSubRuleKeyword_0());
            		
            otherlv_1=(Token)match(input,18,FOLLOW_65); 

            			newLeafNode(otherlv_1, grammarAccess.getSubExpressionAccess().getLeftCurlyBracketKeyword_1());
            		
            // InternalSparrow.g:3886:3: ( (lv_totalExpression_2_0= ruleTotalExpression ) )
            // InternalSparrow.g:3887:4: (lv_totalExpression_2_0= ruleTotalExpression )
            {
            // InternalSparrow.g:3887:4: (lv_totalExpression_2_0= ruleTotalExpression )
            // InternalSparrow.g:3888:5: lv_totalExpression_2_0= ruleTotalExpression
            {

            					newCompositeNode(grammarAccess.getSubExpressionAccess().getTotalExpressionTotalExpressionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_15);
            lv_totalExpression_2_0=ruleTotalExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSubExpressionRule());
            					}
            					set(
            						current,
            						"totalExpression",
            						lv_totalExpression_2_0,
            						"org.xtext.example.mydsl.Sparrow.TotalExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,19,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getSubExpressionAccess().getRightCurlyBracketKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSubExpression"


    // $ANTLR start "entryRuleFailResult"
    // InternalSparrow.g:3913:1: entryRuleFailResult returns [EObject current=null] : iv_ruleFailResult= ruleFailResult EOF ;
    public final EObject entryRuleFailResult() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFailResult = null;


        try {
            // InternalSparrow.g:3913:51: (iv_ruleFailResult= ruleFailResult EOF )
            // InternalSparrow.g:3914:2: iv_ruleFailResult= ruleFailResult EOF
            {
             newCompositeNode(grammarAccess.getFailResultRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFailResult=ruleFailResult();

            state._fsp--;

             current =iv_ruleFailResult; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFailResult"


    // $ANTLR start "ruleFailResult"
    // InternalSparrow.g:3920:1: ruleFailResult returns [EObject current=null] : (otherlv_0= 'FailResult:' ( ( (lv_followingOperation_1_0= ruletrueOperation ) ) | ( (otherlv_2= RULE_ID ) ) ) ( (lv_andor_3_0= ruleAndOrOperationLink ) )* ( (lv_timePoint_4_0= ruleTimepoint ) )? ( (lv_thenoperation_5_0= ruleThenOperation ) )* ) ;
    public final EObject ruleFailResult() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_followingOperation_1_0 = null;

        EObject lv_andor_3_0 = null;

        EObject lv_timePoint_4_0 = null;

        EObject lv_thenoperation_5_0 = null;



        	enterRule();

        try {
            // InternalSparrow.g:3926:2: ( (otherlv_0= 'FailResult:' ( ( (lv_followingOperation_1_0= ruletrueOperation ) ) | ( (otherlv_2= RULE_ID ) ) ) ( (lv_andor_3_0= ruleAndOrOperationLink ) )* ( (lv_timePoint_4_0= ruleTimepoint ) )? ( (lv_thenoperation_5_0= ruleThenOperation ) )* ) )
            // InternalSparrow.g:3927:2: (otherlv_0= 'FailResult:' ( ( (lv_followingOperation_1_0= ruletrueOperation ) ) | ( (otherlv_2= RULE_ID ) ) ) ( (lv_andor_3_0= ruleAndOrOperationLink ) )* ( (lv_timePoint_4_0= ruleTimepoint ) )? ( (lv_thenoperation_5_0= ruleThenOperation ) )* )
            {
            // InternalSparrow.g:3927:2: (otherlv_0= 'FailResult:' ( ( (lv_followingOperation_1_0= ruletrueOperation ) ) | ( (otherlv_2= RULE_ID ) ) ) ( (lv_andor_3_0= ruleAndOrOperationLink ) )* ( (lv_timePoint_4_0= ruleTimepoint ) )? ( (lv_thenoperation_5_0= ruleThenOperation ) )* )
            // InternalSparrow.g:3928:3: otherlv_0= 'FailResult:' ( ( (lv_followingOperation_1_0= ruletrueOperation ) ) | ( (otherlv_2= RULE_ID ) ) ) ( (lv_andor_3_0= ruleAndOrOperationLink ) )* ( (lv_timePoint_4_0= ruleTimepoint ) )? ( (lv_thenoperation_5_0= ruleThenOperation ) )*
            {
            otherlv_0=(Token)match(input,84,FOLLOW_38); 

            			newLeafNode(otherlv_0, grammarAccess.getFailResultAccess().getFailResultKeyword_0());
            		
            // InternalSparrow.g:3932:3: ( ( (lv_followingOperation_1_0= ruletrueOperation ) ) | ( (otherlv_2= RULE_ID ) ) )
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( ((LA71_0>=105 && LA71_0<=107)||LA71_0==114) ) {
                alt71=1;
            }
            else if ( (LA71_0==RULE_ID) ) {
                alt71=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                throw nvae;
            }
            switch (alt71) {
                case 1 :
                    // InternalSparrow.g:3933:4: ( (lv_followingOperation_1_0= ruletrueOperation ) )
                    {
                    // InternalSparrow.g:3933:4: ( (lv_followingOperation_1_0= ruletrueOperation ) )
                    // InternalSparrow.g:3934:5: (lv_followingOperation_1_0= ruletrueOperation )
                    {
                    // InternalSparrow.g:3934:5: (lv_followingOperation_1_0= ruletrueOperation )
                    // InternalSparrow.g:3935:6: lv_followingOperation_1_0= ruletrueOperation
                    {

                    						newCompositeNode(grammarAccess.getFailResultAccess().getFollowingOperationTrueOperationParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_66);
                    lv_followingOperation_1_0=ruletrueOperation();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getFailResultRule());
                    						}
                    						set(
                    							current,
                    							"followingOperation",
                    							lv_followingOperation_1_0,
                    							"org.xtext.example.mydsl.Sparrow.trueOperation");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSparrow.g:3953:4: ( (otherlv_2= RULE_ID ) )
                    {
                    // InternalSparrow.g:3953:4: ( (otherlv_2= RULE_ID ) )
                    // InternalSparrow.g:3954:5: (otherlv_2= RULE_ID )
                    {
                    // InternalSparrow.g:3954:5: (otherlv_2= RULE_ID )
                    // InternalSparrow.g:3955:6: otherlv_2= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getFailResultRule());
                    						}
                    					
                    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_66); 

                    						newLeafNode(otherlv_2, grammarAccess.getFailResultAccess().getLinkOperationOperateLinkCrossReference_1_1_0());
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalSparrow.g:3967:3: ( (lv_andor_3_0= ruleAndOrOperationLink ) )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( (LA72_0==69) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // InternalSparrow.g:3968:4: (lv_andor_3_0= ruleAndOrOperationLink )
            	    {
            	    // InternalSparrow.g:3968:4: (lv_andor_3_0= ruleAndOrOperationLink )
            	    // InternalSparrow.g:3969:5: lv_andor_3_0= ruleAndOrOperationLink
            	    {

            	    					newCompositeNode(grammarAccess.getFailResultAccess().getAndorAndOrOperationLinkParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_66);
            	    lv_andor_3_0=ruleAndOrOperationLink();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getFailResultRule());
            	    					}
            	    					add(
            	    						current,
            	    						"andor",
            	    						lv_andor_3_0,
            	    						"org.xtext.example.mydsl.Sparrow.AndOrOperationLink");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop72;
                }
            } while (true);

            // InternalSparrow.g:3986:3: ( (lv_timePoint_4_0= ruleTimepoint ) )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==85||LA73_0==87) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // InternalSparrow.g:3987:4: (lv_timePoint_4_0= ruleTimepoint )
                    {
                    // InternalSparrow.g:3987:4: (lv_timePoint_4_0= ruleTimepoint )
                    // InternalSparrow.g:3988:5: lv_timePoint_4_0= ruleTimepoint
                    {

                    					newCompositeNode(grammarAccess.getFailResultAccess().getTimePointTimepointParserRuleCall_3_0());
                    				
                    pushFollow(FOLLOW_50);
                    lv_timePoint_4_0=ruleTimepoint();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getFailResultRule());
                    					}
                    					set(
                    						current,
                    						"timePoint",
                    						lv_timePoint_4_0,
                    						"org.xtext.example.mydsl.Sparrow.Timepoint");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalSparrow.g:4005:3: ( (lv_thenoperation_5_0= ruleThenOperation ) )*
            loop74:
            do {
                int alt74=2;
                int LA74_0 = input.LA(1);

                if ( (LA74_0==79) ) {
                    alt74=1;
                }


                switch (alt74) {
            	case 1 :
            	    // InternalSparrow.g:4006:4: (lv_thenoperation_5_0= ruleThenOperation )
            	    {
            	    // InternalSparrow.g:4006:4: (lv_thenoperation_5_0= ruleThenOperation )
            	    // InternalSparrow.g:4007:5: lv_thenoperation_5_0= ruleThenOperation
            	    {

            	    					newCompositeNode(grammarAccess.getFailResultAccess().getThenoperationThenOperationParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_50);
            	    lv_thenoperation_5_0=ruleThenOperation();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getFailResultRule());
            	    					}
            	    					add(
            	    						current,
            	    						"thenoperation",
            	    						lv_thenoperation_5_0,
            	    						"org.xtext.example.mydsl.Sparrow.ThenOperation");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop74;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFailResult"


    // $ANTLR start "entryRuleTimepoint"
    // InternalSparrow.g:4028:1: entryRuleTimepoint returns [EObject current=null] : iv_ruleTimepoint= ruleTimepoint EOF ;
    public final EObject entryRuleTimepoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimepoint = null;


        try {
            // InternalSparrow.g:4028:50: (iv_ruleTimepoint= ruleTimepoint EOF )
            // InternalSparrow.g:4029:2: iv_ruleTimepoint= ruleTimepoint EOF
            {
             newCompositeNode(grammarAccess.getTimepointRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTimepoint=ruleTimepoint();

            state._fsp--;

             current =iv_ruleTimepoint; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTimepoint"


    // $ANTLR start "ruleTimepoint"
    // InternalSparrow.g:4035:1: ruleTimepoint returns [EObject current=null] : (this_WithinPoint_0= ruleWithinPoint | this_BeforePoint_1= ruleBeforePoint ) ;
    public final EObject ruleTimepoint() throws RecognitionException {
        EObject current = null;

        EObject this_WithinPoint_0 = null;

        EObject this_BeforePoint_1 = null;



        	enterRule();

        try {
            // InternalSparrow.g:4041:2: ( (this_WithinPoint_0= ruleWithinPoint | this_BeforePoint_1= ruleBeforePoint ) )
            // InternalSparrow.g:4042:2: (this_WithinPoint_0= ruleWithinPoint | this_BeforePoint_1= ruleBeforePoint )
            {
            // InternalSparrow.g:4042:2: (this_WithinPoint_0= ruleWithinPoint | this_BeforePoint_1= ruleBeforePoint )
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==85) ) {
                alt75=1;
            }
            else if ( (LA75_0==87) ) {
                alt75=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 75, 0, input);

                throw nvae;
            }
            switch (alt75) {
                case 1 :
                    // InternalSparrow.g:4043:3: this_WithinPoint_0= ruleWithinPoint
                    {

                    			newCompositeNode(grammarAccess.getTimepointAccess().getWithinPointParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_WithinPoint_0=ruleWithinPoint();

                    state._fsp--;


                    			current = this_WithinPoint_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalSparrow.g:4052:3: this_BeforePoint_1= ruleBeforePoint
                    {

                    			newCompositeNode(grammarAccess.getTimepointAccess().getBeforePointParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_BeforePoint_1=ruleBeforePoint();

                    state._fsp--;


                    			current = this_BeforePoint_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTimepoint"


    // $ANTLR start "entryRuleWithinPoint"
    // InternalSparrow.g:4064:1: entryRuleWithinPoint returns [EObject current=null] : iv_ruleWithinPoint= ruleWithinPoint EOF ;
    public final EObject entryRuleWithinPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWithinPoint = null;


        try {
            // InternalSparrow.g:4064:52: (iv_ruleWithinPoint= ruleWithinPoint EOF )
            // InternalSparrow.g:4065:2: iv_ruleWithinPoint= ruleWithinPoint EOF
            {
             newCompositeNode(grammarAccess.getWithinPointRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWithinPoint=ruleWithinPoint();

            state._fsp--;

             current =iv_ruleWithinPoint; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWithinPoint"


    // $ANTLR start "ruleWithinPoint"
    // InternalSparrow.g:4071:1: ruleWithinPoint returns [EObject current=null] : (otherlv_0= 'within' ( (lv_number_1_0= RULE_INT ) ) ( (lv_time_2_0= ruleEachTime ) ) otherlv_3= 'after' ( (otherlv_4= RULE_ID ) ) ) ;
    public final EObject ruleWithinPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_number_1_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_time_2_0 = null;



        	enterRule();

        try {
            // InternalSparrow.g:4077:2: ( (otherlv_0= 'within' ( (lv_number_1_0= RULE_INT ) ) ( (lv_time_2_0= ruleEachTime ) ) otherlv_3= 'after' ( (otherlv_4= RULE_ID ) ) ) )
            // InternalSparrow.g:4078:2: (otherlv_0= 'within' ( (lv_number_1_0= RULE_INT ) ) ( (lv_time_2_0= ruleEachTime ) ) otherlv_3= 'after' ( (otherlv_4= RULE_ID ) ) )
            {
            // InternalSparrow.g:4078:2: (otherlv_0= 'within' ( (lv_number_1_0= RULE_INT ) ) ( (lv_time_2_0= ruleEachTime ) ) otherlv_3= 'after' ( (otherlv_4= RULE_ID ) ) )
            // InternalSparrow.g:4079:3: otherlv_0= 'within' ( (lv_number_1_0= RULE_INT ) ) ( (lv_time_2_0= ruleEachTime ) ) otherlv_3= 'after' ( (otherlv_4= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,85,FOLLOW_31); 

            			newLeafNode(otherlv_0, grammarAccess.getWithinPointAccess().getWithinKeyword_0());
            		
            // InternalSparrow.g:4083:3: ( (lv_number_1_0= RULE_INT ) )
            // InternalSparrow.g:4084:4: (lv_number_1_0= RULE_INT )
            {
            // InternalSparrow.g:4084:4: (lv_number_1_0= RULE_INT )
            // InternalSparrow.g:4085:5: lv_number_1_0= RULE_INT
            {
            lv_number_1_0=(Token)match(input,RULE_INT,FOLLOW_28); 

            					newLeafNode(lv_number_1_0, grammarAccess.getWithinPointAccess().getNumberINTTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getWithinPointRule());
            					}
            					setWithLastConsumed(
            						current,
            						"number",
            						lv_number_1_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            // InternalSparrow.g:4101:3: ( (lv_time_2_0= ruleEachTime ) )
            // InternalSparrow.g:4102:4: (lv_time_2_0= ruleEachTime )
            {
            // InternalSparrow.g:4102:4: (lv_time_2_0= ruleEachTime )
            // InternalSparrow.g:4103:5: lv_time_2_0= ruleEachTime
            {

            					newCompositeNode(grammarAccess.getWithinPointAccess().getTimeEachTimeParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_67);
            lv_time_2_0=ruleEachTime();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getWithinPointRule());
            					}
            					set(
            						current,
            						"time",
            						lv_time_2_0,
            						"org.xtext.example.mydsl.Sparrow.EachTime");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,86,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getWithinPointAccess().getAfterKeyword_3());
            		
            // InternalSparrow.g:4124:3: ( (otherlv_4= RULE_ID ) )
            // InternalSparrow.g:4125:4: (otherlv_4= RULE_ID )
            {
            // InternalSparrow.g:4125:4: (otherlv_4= RULE_ID )
            // InternalSparrow.g:4126:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getWithinPointRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(otherlv_4, grammarAccess.getWithinPointAccess().getThingRuleExpressionCrossReference_4_0());
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWithinPoint"


    // $ANTLR start "entryRuleBeforePoint"
    // InternalSparrow.g:4141:1: entryRuleBeforePoint returns [EObject current=null] : iv_ruleBeforePoint= ruleBeforePoint EOF ;
    public final EObject entryRuleBeforePoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBeforePoint = null;


        try {
            // InternalSparrow.g:4141:52: (iv_ruleBeforePoint= ruleBeforePoint EOF )
            // InternalSparrow.g:4142:2: iv_ruleBeforePoint= ruleBeforePoint EOF
            {
             newCompositeNode(grammarAccess.getBeforePointRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBeforePoint=ruleBeforePoint();

            state._fsp--;

             current =iv_ruleBeforePoint; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBeforePoint"


    // $ANTLR start "ruleBeforePoint"
    // InternalSparrow.g:4148:1: ruleBeforePoint returns [EObject current=null] : (otherlv_0= 'before' ( ( (lv_lineTime_1_0= ruleThisDate ) ) | ( (otherlv_2= RULE_ID ) ) ) ) ;
    public final EObject ruleBeforePoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_lineTime_1_0 = null;



        	enterRule();

        try {
            // InternalSparrow.g:4154:2: ( (otherlv_0= 'before' ( ( (lv_lineTime_1_0= ruleThisDate ) ) | ( (otherlv_2= RULE_ID ) ) ) ) )
            // InternalSparrow.g:4155:2: (otherlv_0= 'before' ( ( (lv_lineTime_1_0= ruleThisDate ) ) | ( (otherlv_2= RULE_ID ) ) ) )
            {
            // InternalSparrow.g:4155:2: (otherlv_0= 'before' ( ( (lv_lineTime_1_0= ruleThisDate ) ) | ( (otherlv_2= RULE_ID ) ) ) )
            // InternalSparrow.g:4156:3: otherlv_0= 'before' ( ( (lv_lineTime_1_0= ruleThisDate ) ) | ( (otherlv_2= RULE_ID ) ) )
            {
            otherlv_0=(Token)match(input,87,FOLLOW_68); 

            			newLeafNode(otherlv_0, grammarAccess.getBeforePointAccess().getBeforeKeyword_0());
            		
            // InternalSparrow.g:4160:3: ( ( (lv_lineTime_1_0= ruleThisDate ) ) | ( (otherlv_2= RULE_ID ) ) )
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( (LA76_0==RULE_INT) ) {
                alt76=1;
            }
            else if ( (LA76_0==RULE_ID) ) {
                alt76=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 76, 0, input);

                throw nvae;
            }
            switch (alt76) {
                case 1 :
                    // InternalSparrow.g:4161:4: ( (lv_lineTime_1_0= ruleThisDate ) )
                    {
                    // InternalSparrow.g:4161:4: ( (lv_lineTime_1_0= ruleThisDate ) )
                    // InternalSparrow.g:4162:5: (lv_lineTime_1_0= ruleThisDate )
                    {
                    // InternalSparrow.g:4162:5: (lv_lineTime_1_0= ruleThisDate )
                    // InternalSparrow.g:4163:6: lv_lineTime_1_0= ruleThisDate
                    {

                    						newCompositeNode(grammarAccess.getBeforePointAccess().getLineTimeThisDateParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_lineTime_1_0=ruleThisDate();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getBeforePointRule());
                    						}
                    						set(
                    							current,
                    							"lineTime",
                    							lv_lineTime_1_0,
                    							"org.xtext.example.mydsl.Sparrow.ThisDate");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalSparrow.g:4181:4: ( (otherlv_2= RULE_ID ) )
                    {
                    // InternalSparrow.g:4181:4: ( (otherlv_2= RULE_ID ) )
                    // InternalSparrow.g:4182:5: (otherlv_2= RULE_ID )
                    {
                    // InternalSparrow.g:4182:5: (otherlv_2= RULE_ID )
                    // InternalSparrow.g:4183:6: otherlv_2= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getBeforePointRule());
                    						}
                    					
                    otherlv_2=(Token)match(input,RULE_ID,FOLLOW_2); 

                    						newLeafNode(otherlv_2, grammarAccess.getBeforePointAccess().getValueKeyvalueCrossReference_1_1_0());
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBeforePoint"


    // $ANTLR start "entryRuleSingleCondition"
    // InternalSparrow.g:4199:1: entryRuleSingleCondition returns [EObject current=null] : iv_ruleSingleCondition= ruleSingleCondition EOF ;
    public final EObject entryRuleSingleCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleCondition = null;


        try {
            // InternalSparrow.g:4199:56: (iv_ruleSingleCondition= ruleSingleCondition EOF )
            // InternalSparrow.g:4200:2: iv_ruleSingleCondition= ruleSingleCondition EOF
            {
             newCompositeNode(grammarAccess.getSingleConditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSingleCondition=ruleSingleCondition();

            state._fsp--;

             current =iv_ruleSingleCondition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSingleCondition"


    // $ANTLR start "ruleSingleCondition"
    // InternalSparrow.g:4206:1: ruleSingleCondition returns [EObject current=null] : ( ( (lv_no_0_0= '!' ) )? ( (lv_condition_1_0= ruleTrueCondition ) ) ) ;
    public final EObject ruleSingleCondition() throws RecognitionException {
        EObject current = null;

        Token lv_no_0_0=null;
        EObject lv_condition_1_0 = null;



        	enterRule();

        try {
            // InternalSparrow.g:4212:2: ( ( ( (lv_no_0_0= '!' ) )? ( (lv_condition_1_0= ruleTrueCondition ) ) ) )
            // InternalSparrow.g:4213:2: ( ( (lv_no_0_0= '!' ) )? ( (lv_condition_1_0= ruleTrueCondition ) ) )
            {
            // InternalSparrow.g:4213:2: ( ( (lv_no_0_0= '!' ) )? ( (lv_condition_1_0= ruleTrueCondition ) ) )
            // InternalSparrow.g:4214:3: ( (lv_no_0_0= '!' ) )? ( (lv_condition_1_0= ruleTrueCondition ) )
            {
            // InternalSparrow.g:4214:3: ( (lv_no_0_0= '!' ) )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==77) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // InternalSparrow.g:4215:4: (lv_no_0_0= '!' )
                    {
                    // InternalSparrow.g:4215:4: (lv_no_0_0= '!' )
                    // InternalSparrow.g:4216:5: lv_no_0_0= '!'
                    {
                    lv_no_0_0=(Token)match(input,77,FOLLOW_69); 

                    					newLeafNode(lv_no_0_0, grammarAccess.getSingleConditionAccess().getNoExclamationMarkKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getSingleConditionRule());
                    					}
                    					setWithLastConsumed(current, "no", lv_no_0_0, "!");
                    				

                    }


                    }
                    break;

            }

            // InternalSparrow.g:4228:3: ( (lv_condition_1_0= ruleTrueCondition ) )
            // InternalSparrow.g:4229:4: (lv_condition_1_0= ruleTrueCondition )
            {
            // InternalSparrow.g:4229:4: (lv_condition_1_0= ruleTrueCondition )
            // InternalSparrow.g:4230:5: lv_condition_1_0= ruleTrueCondition
            {

            					newCompositeNode(grammarAccess.getSingleConditionAccess().getConditionTrueConditionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_condition_1_0=ruleTrueCondition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getSingleConditionRule());
            					}
            					set(
            						current,
            						"condition",
            						lv_condition_1_0,
            						"org.xtext.example.mydsl.Sparrow.TrueCondition");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSingleCondition"


    // $ANTLR start "entryRuleTrueCondition"
    // InternalSparrow.g:4251:1: entryRuleTrueCondition returns [EObject current=null] : iv_ruleTrueCondition= ruleTrueCondition EOF ;
    public final EObject entryRuleTrueCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrueCondition = null;


        try {
            // InternalSparrow.g:4251:54: (iv_ruleTrueCondition= ruleTrueCondition EOF )
            // InternalSparrow.g:4252:2: iv_ruleTrueCondition= ruleTrueCondition EOF
            {
             newCompositeNode(grammarAccess.getTrueConditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTrueCondition=ruleTrueCondition();

            state._fsp--;

             current =iv_ruleTrueCondition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTrueCondition"


    // $ANTLR start "ruleTrueCondition"
    // InternalSparrow.g:4258:1: ruleTrueCondition returns [EObject current=null] : (this_isTime_0= ruleisTime | this_logic_1= rulelogic | this_isTrue_2= ruleisTrue | this_isDone_3= ruleisDone | this_checkExpression_4= rulecheckExpression | this_Timepoint_5= ruleTimepoint | this_CompareString_6= ruleCompareString | this_TimeSub_7= ruleTimeSub ) ;
    public final EObject ruleTrueCondition() throws RecognitionException {
        EObject current = null;

        EObject this_isTime_0 = null;

        EObject this_logic_1 = null;

        EObject this_isTrue_2 = null;

        EObject this_isDone_3 = null;

        EObject this_checkExpression_4 = null;

        EObject this_Timepoint_5 = null;

        EObject this_CompareString_6 = null;

        EObject this_TimeSub_7 = null;



        	enterRule();

        try {
            // InternalSparrow.g:4264:2: ( (this_isTime_0= ruleisTime | this_logic_1= rulelogic | this_isTrue_2= ruleisTrue | this_isDone_3= ruleisDone | this_checkExpression_4= rulecheckExpression | this_Timepoint_5= ruleTimepoint | this_CompareString_6= ruleCompareString | this_TimeSub_7= ruleTimeSub ) )
            // InternalSparrow.g:4265:2: (this_isTime_0= ruleisTime | this_logic_1= rulelogic | this_isTrue_2= ruleisTrue | this_isDone_3= ruleisDone | this_checkExpression_4= rulecheckExpression | this_Timepoint_5= ruleTimepoint | this_CompareString_6= ruleCompareString | this_TimeSub_7= ruleTimeSub )
            {
            // InternalSparrow.g:4265:2: (this_isTime_0= ruleisTime | this_logic_1= rulelogic | this_isTrue_2= ruleisTrue | this_isDone_3= ruleisDone | this_checkExpression_4= rulecheckExpression | this_Timepoint_5= ruleTimepoint | this_CompareString_6= ruleCompareString | this_TimeSub_7= ruleTimeSub )
            int alt78=8;
            switch ( input.LA(1) ) {
            case 91:
                {
                alt78=1;
                }
                break;
            case 92:
                {
                alt78=2;
                }
                break;
            case 93:
                {
                alt78=3;
                }
                break;
            case 94:
                {
                alt78=4;
                }
                break;
            case 95:
                {
                alt78=5;
                }
                break;
            case 85:
            case 87:
                {
                alt78=6;
                }
                break;
            case 88:
                {
                alt78=7;
                }
                break;
            case 89:
                {
                alt78=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 78, 0, input);

                throw nvae;
            }

            switch (alt78) {
                case 1 :
                    // InternalSparrow.g:4266:3: this_isTime_0= ruleisTime
                    {

                    			newCompositeNode(grammarAccess.getTrueConditionAccess().getIsTimeParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_isTime_0=ruleisTime();

                    state._fsp--;


                    			current = this_isTime_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalSparrow.g:4275:3: this_logic_1= rulelogic
                    {

                    			newCompositeNode(grammarAccess.getTrueConditionAccess().getLogicParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_logic_1=rulelogic();

                    state._fsp--;


                    			current = this_logic_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalSparrow.g:4284:3: this_isTrue_2= ruleisTrue
                    {

                    			newCompositeNode(grammarAccess.getTrueConditionAccess().getIsTrueParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_isTrue_2=ruleisTrue();

                    state._fsp--;


                    			current = this_isTrue_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalSparrow.g:4293:3: this_isDone_3= ruleisDone
                    {

                    			newCompositeNode(grammarAccess.getTrueConditionAccess().getIsDoneParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_isDone_3=ruleisDone();

                    state._fsp--;


                    			current = this_isDone_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalSparrow.g:4302:3: this_checkExpression_4= rulecheckExpression
                    {

                    			newCompositeNode(grammarAccess.getTrueConditionAccess().getCheckExpressionParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_checkExpression_4=rulecheckExpression();

                    state._fsp--;


                    			current = this_checkExpression_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalSparrow.g:4311:3: this_Timepoint_5= ruleTimepoint
                    {

                    			newCompositeNode(grammarAccess.getTrueConditionAccess().getTimepointParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_Timepoint_5=ruleTimepoint();

                    state._fsp--;


                    			current = this_Timepoint_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalSparrow.g:4320:3: this_CompareString_6= ruleCompareString
                    {

                    			newCompositeNode(grammarAccess.getTrueConditionAccess().getCompareStringParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_CompareString_6=ruleCompareString();

                    state._fsp--;


                    			current = this_CompareString_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 8 :
                    // InternalSparrow.g:4329:3: this_TimeSub_7= ruleTimeSub
                    {

                    			newCompositeNode(grammarAccess.getTrueConditionAccess().getTimeSubParserRuleCall_7());
                    		
                    pushFollow(FOLLOW_2);
                    this_TimeSub_7=ruleTimeSub();

                    state._fsp--;


                    			current = this_TimeSub_7;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTrueCondition"


    // $ANTLR start "entryRuleCompareString"
    // InternalSparrow.g:4341:1: entryRuleCompareString returns [EObject current=null] : iv_ruleCompareString= ruleCompareString EOF ;
    public final EObject entryRuleCompareString() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompareString = null;


        try {
            // InternalSparrow.g:4341:54: (iv_ruleCompareString= ruleCompareString EOF )
            // InternalSparrow.g:4342:2: iv_ruleCompareString= ruleCompareString EOF
            {
             newCompositeNode(grammarAccess.getCompareStringRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCompareString=ruleCompareString();

            state._fsp--;

             current =iv_ruleCompareString; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCompareString"


    // $ANTLR start "ruleCompareString"
    // InternalSparrow.g:4348:1: ruleCompareString returns [EObject current=null] : (otherlv_0= 'compareString(' ( (lv_valueA_1_0= ruleMixExpression ) ) otherlv_2= ',' ( (lv_valueB_3_0= ruleMixExpression ) ) otherlv_4= ')' ) ;
    public final EObject ruleCompareString() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_valueA_1_0 = null;

        EObject lv_valueB_3_0 = null;



        	enterRule();

        try {
            // InternalSparrow.g:4354:2: ( (otherlv_0= 'compareString(' ( (lv_valueA_1_0= ruleMixExpression ) ) otherlv_2= ',' ( (lv_valueB_3_0= ruleMixExpression ) ) otherlv_4= ')' ) )
            // InternalSparrow.g:4355:2: (otherlv_0= 'compareString(' ( (lv_valueA_1_0= ruleMixExpression ) ) otherlv_2= ',' ( (lv_valueB_3_0= ruleMixExpression ) ) otherlv_4= ')' )
            {
            // InternalSparrow.g:4355:2: (otherlv_0= 'compareString(' ( (lv_valueA_1_0= ruleMixExpression ) ) otherlv_2= ',' ( (lv_valueB_3_0= ruleMixExpression ) ) otherlv_4= ')' )
            // InternalSparrow.g:4356:3: otherlv_0= 'compareString(' ( (lv_valueA_1_0= ruleMixExpression ) ) otherlv_2= ',' ( (lv_valueB_3_0= ruleMixExpression ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,88,FOLLOW_70); 

            			newLeafNode(otherlv_0, grammarAccess.getCompareStringAccess().getCompareStringKeyword_0());
            		
            // InternalSparrow.g:4360:3: ( (lv_valueA_1_0= ruleMixExpression ) )
            // InternalSparrow.g:4361:4: (lv_valueA_1_0= ruleMixExpression )
            {
            // InternalSparrow.g:4361:4: (lv_valueA_1_0= ruleMixExpression )
            // InternalSparrow.g:4362:5: lv_valueA_1_0= ruleMixExpression
            {

            					newCompositeNode(grammarAccess.getCompareStringAccess().getValueAMixExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_32);
            lv_valueA_1_0=ruleMixExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCompareStringRule());
            					}
            					set(
            						current,
            						"valueA",
            						lv_valueA_1_0,
            						"org.xtext.example.mydsl.Sparrow.MixExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,22,FOLLOW_70); 

            			newLeafNode(otherlv_2, grammarAccess.getCompareStringAccess().getCommaKeyword_2());
            		
            // InternalSparrow.g:4383:3: ( (lv_valueB_3_0= ruleMixExpression ) )
            // InternalSparrow.g:4384:4: (lv_valueB_3_0= ruleMixExpression )
            {
            // InternalSparrow.g:4384:4: (lv_valueB_3_0= ruleMixExpression )
            // InternalSparrow.g:4385:5: lv_valueB_3_0= ruleMixExpression
            {

            					newCompositeNode(grammarAccess.getCompareStringAccess().getValueBMixExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_64);
            lv_valueB_3_0=ruleMixExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getCompareStringRule());
            					}
            					set(
            						current,
            						"valueB",
            						lv_valueB_3_0,
            						"org.xtext.example.mydsl.Sparrow.MixExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,39,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getCompareStringAccess().getRightParenthesisKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCompareString"


    // $ANTLR start "entryRuleTimeSub"
    // InternalSparrow.g:4410:1: entryRuleTimeSub returns [EObject current=null] : iv_ruleTimeSub= ruleTimeSub EOF ;
    public final EObject entryRuleTimeSub() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimeSub = null;


        try {
            // InternalSparrow.g:4410:48: (iv_ruleTimeSub= ruleTimeSub EOF )
            // InternalSparrow.g:4411:2: iv_ruleTimeSub= ruleTimeSub EOF
            {
             newCompositeNode(grammarAccess.getTimeSubRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTimeSub=ruleTimeSub();

            state._fsp--;

             current =iv_ruleTimeSub; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTimeSub"


    // $ANTLR start "ruleTimeSub"
    // InternalSparrow.g:4417:1: ruleTimeSub returns [EObject current=null] : (otherlv_0= 'timeSub(' ( (lv_valueA_1_0= ruleMixExpression ) ) otherlv_2= ',' ( (lv_valueB_3_0= ruleMixExpression ) )? (otherlv_4= 'r' ( (otherlv_5= RULE_ID ) ) )? otherlv_6= ',' ( (lv_duration_7_0= ruleDuration ) ) otherlv_8= ',' ( (lv_compare_9_0= RULE_MATH_SYMBOL ) ) otherlv_10= ')' ) ;
    public final EObject ruleTimeSub() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token lv_compare_9_0=null;
        Token otherlv_10=null;
        EObject lv_valueA_1_0 = null;

        EObject lv_valueB_3_0 = null;

        EObject lv_duration_7_0 = null;



        	enterRule();

        try {
            // InternalSparrow.g:4423:2: ( (otherlv_0= 'timeSub(' ( (lv_valueA_1_0= ruleMixExpression ) ) otherlv_2= ',' ( (lv_valueB_3_0= ruleMixExpression ) )? (otherlv_4= 'r' ( (otherlv_5= RULE_ID ) ) )? otherlv_6= ',' ( (lv_duration_7_0= ruleDuration ) ) otherlv_8= ',' ( (lv_compare_9_0= RULE_MATH_SYMBOL ) ) otherlv_10= ')' ) )
            // InternalSparrow.g:4424:2: (otherlv_0= 'timeSub(' ( (lv_valueA_1_0= ruleMixExpression ) ) otherlv_2= ',' ( (lv_valueB_3_0= ruleMixExpression ) )? (otherlv_4= 'r' ( (otherlv_5= RULE_ID ) ) )? otherlv_6= ',' ( (lv_duration_7_0= ruleDuration ) ) otherlv_8= ',' ( (lv_compare_9_0= RULE_MATH_SYMBOL ) ) otherlv_10= ')' )
            {
            // InternalSparrow.g:4424:2: (otherlv_0= 'timeSub(' ( (lv_valueA_1_0= ruleMixExpression ) ) otherlv_2= ',' ( (lv_valueB_3_0= ruleMixExpression ) )? (otherlv_4= 'r' ( (otherlv_5= RULE_ID ) ) )? otherlv_6= ',' ( (lv_duration_7_0= ruleDuration ) ) otherlv_8= ',' ( (lv_compare_9_0= RULE_MATH_SYMBOL ) ) otherlv_10= ')' )
            // InternalSparrow.g:4425:3: otherlv_0= 'timeSub(' ( (lv_valueA_1_0= ruleMixExpression ) ) otherlv_2= ',' ( (lv_valueB_3_0= ruleMixExpression ) )? (otherlv_4= 'r' ( (otherlv_5= RULE_ID ) ) )? otherlv_6= ',' ( (lv_duration_7_0= ruleDuration ) ) otherlv_8= ',' ( (lv_compare_9_0= RULE_MATH_SYMBOL ) ) otherlv_10= ')'
            {
            otherlv_0=(Token)match(input,89,FOLLOW_70); 

            			newLeafNode(otherlv_0, grammarAccess.getTimeSubAccess().getTimeSubKeyword_0());
            		
            // InternalSparrow.g:4429:3: ( (lv_valueA_1_0= ruleMixExpression ) )
            // InternalSparrow.g:4430:4: (lv_valueA_1_0= ruleMixExpression )
            {
            // InternalSparrow.g:4430:4: (lv_valueA_1_0= ruleMixExpression )
            // InternalSparrow.g:4431:5: lv_valueA_1_0= ruleMixExpression
            {

            					newCompositeNode(grammarAccess.getTimeSubAccess().getValueAMixExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_32);
            lv_valueA_1_0=ruleMixExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTimeSubRule());
            					}
            					set(
            						current,
            						"valueA",
            						lv_valueA_1_0,
            						"org.xtext.example.mydsl.Sparrow.MixExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,22,FOLLOW_71); 

            			newLeafNode(otherlv_2, grammarAccess.getTimeSubAccess().getCommaKeyword_2());
            		
            // InternalSparrow.g:4452:3: ( (lv_valueB_3_0= ruleMixExpression ) )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( ((LA79_0>=RULE_ID && LA79_0<=RULE_INT)||LA79_0==RULE_DECIMAL||LA79_0==62||(LA79_0>=96 && LA79_0<=100)||LA79_0==102||(LA79_0>=116 && LA79_0<=117)) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // InternalSparrow.g:4453:4: (lv_valueB_3_0= ruleMixExpression )
                    {
                    // InternalSparrow.g:4453:4: (lv_valueB_3_0= ruleMixExpression )
                    // InternalSparrow.g:4454:5: lv_valueB_3_0= ruleMixExpression
                    {

                    					newCompositeNode(grammarAccess.getTimeSubAccess().getValueBMixExpressionParserRuleCall_3_0());
                    				
                    pushFollow(FOLLOW_72);
                    lv_valueB_3_0=ruleMixExpression();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getTimeSubRule());
                    					}
                    					set(
                    						current,
                    						"valueB",
                    						lv_valueB_3_0,
                    						"org.xtext.example.mydsl.Sparrow.MixExpression");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalSparrow.g:4471:3: (otherlv_4= 'r' ( (otherlv_5= RULE_ID ) ) )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( (LA80_0==90) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // InternalSparrow.g:4472:4: otherlv_4= 'r' ( (otherlv_5= RULE_ID ) )
                    {
                    otherlv_4=(Token)match(input,90,FOLLOW_3); 

                    				newLeafNode(otherlv_4, grammarAccess.getTimeSubAccess().getRKeyword_4_0());
                    			
                    // InternalSparrow.g:4476:4: ( (otherlv_5= RULE_ID ) )
                    // InternalSparrow.g:4477:5: (otherlv_5= RULE_ID )
                    {
                    // InternalSparrow.g:4477:5: (otherlv_5= RULE_ID )
                    // InternalSparrow.g:4478:6: otherlv_5= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getTimeSubRule());
                    						}
                    					
                    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_32); 

                    						newLeafNode(otherlv_5, grammarAccess.getTimeSubAccess().getValueCRuleExpressionCrossReference_4_1_0());
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_6=(Token)match(input,22,FOLLOW_31); 

            			newLeafNode(otherlv_6, grammarAccess.getTimeSubAccess().getCommaKeyword_5());
            		
            // InternalSparrow.g:4494:3: ( (lv_duration_7_0= ruleDuration ) )
            // InternalSparrow.g:4495:4: (lv_duration_7_0= ruleDuration )
            {
            // InternalSparrow.g:4495:4: (lv_duration_7_0= ruleDuration )
            // InternalSparrow.g:4496:5: lv_duration_7_0= ruleDuration
            {

            					newCompositeNode(grammarAccess.getTimeSubAccess().getDurationDurationParserRuleCall_6_0());
            				
            pushFollow(FOLLOW_32);
            lv_duration_7_0=ruleDuration();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTimeSubRule());
            					}
            					set(
            						current,
            						"duration",
            						lv_duration_7_0,
            						"org.xtext.example.mydsl.Sparrow.Duration");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_8=(Token)match(input,22,FOLLOW_73); 

            			newLeafNode(otherlv_8, grammarAccess.getTimeSubAccess().getCommaKeyword_7());
            		
            // InternalSparrow.g:4517:3: ( (lv_compare_9_0= RULE_MATH_SYMBOL ) )
            // InternalSparrow.g:4518:4: (lv_compare_9_0= RULE_MATH_SYMBOL )
            {
            // InternalSparrow.g:4518:4: (lv_compare_9_0= RULE_MATH_SYMBOL )
            // InternalSparrow.g:4519:5: lv_compare_9_0= RULE_MATH_SYMBOL
            {
            lv_compare_9_0=(Token)match(input,RULE_MATH_SYMBOL,FOLLOW_64); 

            					newLeafNode(lv_compare_9_0, grammarAccess.getTimeSubAccess().getCompareMATH_SYMBOLTerminalRuleCall_8_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTimeSubRule());
            					}
            					setWithLastConsumed(
            						current,
            						"compare",
            						lv_compare_9_0,
            						"org.xtext.example.mydsl.Sparrow.MATH_SYMBOL");
            				

            }


            }

            otherlv_10=(Token)match(input,39,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getTimeSubAccess().getRightParenthesisKeyword_9());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTimeSub"


    // $ANTLR start "entryRuleEachTime"
    // InternalSparrow.g:4543:1: entryRuleEachTime returns [String current=null] : iv_ruleEachTime= ruleEachTime EOF ;
    public final String entryRuleEachTime() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEachTime = null;


        try {
            // InternalSparrow.g:4543:48: (iv_ruleEachTime= ruleEachTime EOF )
            // InternalSparrow.g:4544:2: iv_ruleEachTime= ruleEachTime EOF
            {
             newCompositeNode(grammarAccess.getEachTimeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEachTime=ruleEachTime();

            state._fsp--;

             current =iv_ruleEachTime.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEachTime"


    // $ANTLR start "ruleEachTime"
    // InternalSparrow.g:4550:1: ruleEachTime returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'years' | kw= 'months' | kw= 'days' | kw= 'hours' | kw= 'mins' ) ;
    public final AntlrDatatypeRuleToken ruleEachTime() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSparrow.g:4556:2: ( (kw= 'years' | kw= 'months' | kw= 'days' | kw= 'hours' | kw= 'mins' ) )
            // InternalSparrow.g:4557:2: (kw= 'years' | kw= 'months' | kw= 'days' | kw= 'hours' | kw= 'mins' )
            {
            // InternalSparrow.g:4557:2: (kw= 'years' | kw= 'months' | kw= 'days' | kw= 'hours' | kw= 'mins' )
            int alt81=5;
            switch ( input.LA(1) ) {
            case 57:
                {
                alt81=1;
                }
                break;
            case 58:
                {
                alt81=2;
                }
                break;
            case 59:
                {
                alt81=3;
                }
                break;
            case 60:
                {
                alt81=4;
                }
                break;
            case 61:
                {
                alt81=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 81, 0, input);

                throw nvae;
            }

            switch (alt81) {
                case 1 :
                    // InternalSparrow.g:4558:3: kw= 'years'
                    {
                    kw=(Token)match(input,57,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEachTimeAccess().getYearsKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalSparrow.g:4564:3: kw= 'months'
                    {
                    kw=(Token)match(input,58,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEachTimeAccess().getMonthsKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalSparrow.g:4570:3: kw= 'days'
                    {
                    kw=(Token)match(input,59,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEachTimeAccess().getDaysKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalSparrow.g:4576:3: kw= 'hours'
                    {
                    kw=(Token)match(input,60,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEachTimeAccess().getHoursKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalSparrow.g:4582:3: kw= 'mins'
                    {
                    kw=(Token)match(input,61,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getEachTimeAccess().getMinsKeyword_4());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEachTime"


    // $ANTLR start "entryRuleisTime"
    // InternalSparrow.g:4591:1: entryRuleisTime returns [EObject current=null] : iv_ruleisTime= ruleisTime EOF ;
    public final EObject entryRuleisTime() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleisTime = null;


        try {
            // InternalSparrow.g:4591:47: (iv_ruleisTime= ruleisTime EOF )
            // InternalSparrow.g:4592:2: iv_ruleisTime= ruleisTime EOF
            {
             newCompositeNode(grammarAccess.getIsTimeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleisTime=ruleisTime();

            state._fsp--;

             current =iv_ruleisTime; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleisTime"


    // $ANTLR start "ruleisTime"
    // InternalSparrow.g:4598:1: ruleisTime returns [EObject current=null] : ( () otherlv_1= 'isTime(' ( (lv_expression_2_0= ruleMixExpression ) )? (otherlv_3= 'r' ( (otherlv_4= RULE_ID ) ) )? ( ( (lv_symbol_5_0= RULE_ARITHMETIC_OPERATOR ) ) ( (lv_duration_6_0= ruleDuration ) ) )? otherlv_7= ')' ) ;
    public final EObject ruleisTime() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_symbol_5_0=null;
        Token otherlv_7=null;
        EObject lv_expression_2_0 = null;

        EObject lv_duration_6_0 = null;



        	enterRule();

        try {
            // InternalSparrow.g:4604:2: ( ( () otherlv_1= 'isTime(' ( (lv_expression_2_0= ruleMixExpression ) )? (otherlv_3= 'r' ( (otherlv_4= RULE_ID ) ) )? ( ( (lv_symbol_5_0= RULE_ARITHMETIC_OPERATOR ) ) ( (lv_duration_6_0= ruleDuration ) ) )? otherlv_7= ')' ) )
            // InternalSparrow.g:4605:2: ( () otherlv_1= 'isTime(' ( (lv_expression_2_0= ruleMixExpression ) )? (otherlv_3= 'r' ( (otherlv_4= RULE_ID ) ) )? ( ( (lv_symbol_5_0= RULE_ARITHMETIC_OPERATOR ) ) ( (lv_duration_6_0= ruleDuration ) ) )? otherlv_7= ')' )
            {
            // InternalSparrow.g:4605:2: ( () otherlv_1= 'isTime(' ( (lv_expression_2_0= ruleMixExpression ) )? (otherlv_3= 'r' ( (otherlv_4= RULE_ID ) ) )? ( ( (lv_symbol_5_0= RULE_ARITHMETIC_OPERATOR ) ) ( (lv_duration_6_0= ruleDuration ) ) )? otherlv_7= ')' )
            // InternalSparrow.g:4606:3: () otherlv_1= 'isTime(' ( (lv_expression_2_0= ruleMixExpression ) )? (otherlv_3= 'r' ( (otherlv_4= RULE_ID ) ) )? ( ( (lv_symbol_5_0= RULE_ARITHMETIC_OPERATOR ) ) ( (lv_duration_6_0= ruleDuration ) ) )? otherlv_7= ')'
            {
            // InternalSparrow.g:4606:3: ()
            // InternalSparrow.g:4607:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getIsTimeAccess().getIsTimeAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,91,FOLLOW_74); 

            			newLeafNode(otherlv_1, grammarAccess.getIsTimeAccess().getIsTimeKeyword_1());
            		
            // InternalSparrow.g:4617:3: ( (lv_expression_2_0= ruleMixExpression ) )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( ((LA82_0>=RULE_ID && LA82_0<=RULE_INT)||LA82_0==RULE_DECIMAL||LA82_0==62||(LA82_0>=96 && LA82_0<=100)||LA82_0==102||(LA82_0>=116 && LA82_0<=117)) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // InternalSparrow.g:4618:4: (lv_expression_2_0= ruleMixExpression )
                    {
                    // InternalSparrow.g:4618:4: (lv_expression_2_0= ruleMixExpression )
                    // InternalSparrow.g:4619:5: lv_expression_2_0= ruleMixExpression
                    {

                    					newCompositeNode(grammarAccess.getIsTimeAccess().getExpressionMixExpressionParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_75);
                    lv_expression_2_0=ruleMixExpression();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getIsTimeRule());
                    					}
                    					set(
                    						current,
                    						"expression",
                    						lv_expression_2_0,
                    						"org.xtext.example.mydsl.Sparrow.MixExpression");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalSparrow.g:4636:3: (otherlv_3= 'r' ( (otherlv_4= RULE_ID ) ) )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==90) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // InternalSparrow.g:4637:4: otherlv_3= 'r' ( (otherlv_4= RULE_ID ) )
                    {
                    otherlv_3=(Token)match(input,90,FOLLOW_3); 

                    				newLeafNode(otherlv_3, grammarAccess.getIsTimeAccess().getRKeyword_3_0());
                    			
                    // InternalSparrow.g:4641:4: ( (otherlv_4= RULE_ID ) )
                    // InternalSparrow.g:4642:5: (otherlv_4= RULE_ID )
                    {
                    // InternalSparrow.g:4642:5: (otherlv_4= RULE_ID )
                    // InternalSparrow.g:4643:6: otherlv_4= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getIsTimeRule());
                    						}
                    					
                    otherlv_4=(Token)match(input,RULE_ID,FOLLOW_76); 

                    						newLeafNode(otherlv_4, grammarAccess.getIsTimeAccess().getValueRuleExpressionCrossReference_3_1_0());
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalSparrow.g:4655:3: ( ( (lv_symbol_5_0= RULE_ARITHMETIC_OPERATOR ) ) ( (lv_duration_6_0= ruleDuration ) ) )?
            int alt84=2;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==RULE_ARITHMETIC_OPERATOR) ) {
                alt84=1;
            }
            switch (alt84) {
                case 1 :
                    // InternalSparrow.g:4656:4: ( (lv_symbol_5_0= RULE_ARITHMETIC_OPERATOR ) ) ( (lv_duration_6_0= ruleDuration ) )
                    {
                    // InternalSparrow.g:4656:4: ( (lv_symbol_5_0= RULE_ARITHMETIC_OPERATOR ) )
                    // InternalSparrow.g:4657:5: (lv_symbol_5_0= RULE_ARITHMETIC_OPERATOR )
                    {
                    // InternalSparrow.g:4657:5: (lv_symbol_5_0= RULE_ARITHMETIC_OPERATOR )
                    // InternalSparrow.g:4658:6: lv_symbol_5_0= RULE_ARITHMETIC_OPERATOR
                    {
                    lv_symbol_5_0=(Token)match(input,RULE_ARITHMETIC_OPERATOR,FOLLOW_31); 

                    						newLeafNode(lv_symbol_5_0, grammarAccess.getIsTimeAccess().getSymbolARITHMETIC_OPERATORTerminalRuleCall_4_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getIsTimeRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"symbol",
                    							lv_symbol_5_0,
                    							"org.xtext.example.mydsl.Sparrow.ARITHMETIC_OPERATOR");
                    					

                    }


                    }

                    // InternalSparrow.g:4674:4: ( (lv_duration_6_0= ruleDuration ) )
                    // InternalSparrow.g:4675:5: (lv_duration_6_0= ruleDuration )
                    {
                    // InternalSparrow.g:4675:5: (lv_duration_6_0= ruleDuration )
                    // InternalSparrow.g:4676:6: lv_duration_6_0= ruleDuration
                    {

                    						newCompositeNode(grammarAccess.getIsTimeAccess().getDurationDurationParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_64);
                    lv_duration_6_0=ruleDuration();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getIsTimeRule());
                    						}
                    						set(
                    							current,
                    							"duration",
                    							lv_duration_6_0,
                    							"org.xtext.example.mydsl.Sparrow.Duration");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,39,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getIsTimeAccess().getRightParenthesisKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleisTime"


    // $ANTLR start "entryRulelogic"
    // InternalSparrow.g:4702:1: entryRulelogic returns [EObject current=null] : iv_rulelogic= rulelogic EOF ;
    public final EObject entryRulelogic() throws RecognitionException {
        EObject current = null;

        EObject iv_rulelogic = null;


        try {
            // InternalSparrow.g:4702:46: (iv_rulelogic= rulelogic EOF )
            // InternalSparrow.g:4703:2: iv_rulelogic= rulelogic EOF
            {
             newCompositeNode(grammarAccess.getLogicRule()); 
            pushFollow(FOLLOW_1);
            iv_rulelogic=rulelogic();

            state._fsp--;

             current =iv_rulelogic; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulelogic"


    // $ANTLR start "rulelogic"
    // InternalSparrow.g:4709:1: rulelogic returns [EObject current=null] : (otherlv_0= 'logic(' ( (lv_valueA_1_0= ruleMixExpression ) ) otherlv_2= ',' ( (lv_valueB_3_0= ruleMixExpression ) ) otherlv_4= ',' ( (lv_mathSymbol_5_0= RULE_MATH_SYMBOL ) ) otherlv_6= ')' ) ;
    public final EObject rulelogic() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_mathSymbol_5_0=null;
        Token otherlv_6=null;
        EObject lv_valueA_1_0 = null;

        EObject lv_valueB_3_0 = null;



        	enterRule();

        try {
            // InternalSparrow.g:4715:2: ( (otherlv_0= 'logic(' ( (lv_valueA_1_0= ruleMixExpression ) ) otherlv_2= ',' ( (lv_valueB_3_0= ruleMixExpression ) ) otherlv_4= ',' ( (lv_mathSymbol_5_0= RULE_MATH_SYMBOL ) ) otherlv_6= ')' ) )
            // InternalSparrow.g:4716:2: (otherlv_0= 'logic(' ( (lv_valueA_1_0= ruleMixExpression ) ) otherlv_2= ',' ( (lv_valueB_3_0= ruleMixExpression ) ) otherlv_4= ',' ( (lv_mathSymbol_5_0= RULE_MATH_SYMBOL ) ) otherlv_6= ')' )
            {
            // InternalSparrow.g:4716:2: (otherlv_0= 'logic(' ( (lv_valueA_1_0= ruleMixExpression ) ) otherlv_2= ',' ( (lv_valueB_3_0= ruleMixExpression ) ) otherlv_4= ',' ( (lv_mathSymbol_5_0= RULE_MATH_SYMBOL ) ) otherlv_6= ')' )
            // InternalSparrow.g:4717:3: otherlv_0= 'logic(' ( (lv_valueA_1_0= ruleMixExpression ) ) otherlv_2= ',' ( (lv_valueB_3_0= ruleMixExpression ) ) otherlv_4= ',' ( (lv_mathSymbol_5_0= RULE_MATH_SYMBOL ) ) otherlv_6= ')'
            {
            otherlv_0=(Token)match(input,92,FOLLOW_70); 

            			newLeafNode(otherlv_0, grammarAccess.getLogicAccess().getLogicKeyword_0());
            		
            // InternalSparrow.g:4721:3: ( (lv_valueA_1_0= ruleMixExpression ) )
            // InternalSparrow.g:4722:4: (lv_valueA_1_0= ruleMixExpression )
            {
            // InternalSparrow.g:4722:4: (lv_valueA_1_0= ruleMixExpression )
            // InternalSparrow.g:4723:5: lv_valueA_1_0= ruleMixExpression
            {

            					newCompositeNode(grammarAccess.getLogicAccess().getValueAMixExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_32);
            lv_valueA_1_0=ruleMixExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLogicRule());
            					}
            					set(
            						current,
            						"valueA",
            						lv_valueA_1_0,
            						"org.xtext.example.mydsl.Sparrow.MixExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,22,FOLLOW_70); 

            			newLeafNode(otherlv_2, grammarAccess.getLogicAccess().getCommaKeyword_2());
            		
            // InternalSparrow.g:4744:3: ( (lv_valueB_3_0= ruleMixExpression ) )
            // InternalSparrow.g:4745:4: (lv_valueB_3_0= ruleMixExpression )
            {
            // InternalSparrow.g:4745:4: (lv_valueB_3_0= ruleMixExpression )
            // InternalSparrow.g:4746:5: lv_valueB_3_0= ruleMixExpression
            {

            					newCompositeNode(grammarAccess.getLogicAccess().getValueBMixExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_32);
            lv_valueB_3_0=ruleMixExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLogicRule());
            					}
            					set(
            						current,
            						"valueB",
            						lv_valueB_3_0,
            						"org.xtext.example.mydsl.Sparrow.MixExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,22,FOLLOW_73); 

            			newLeafNode(otherlv_4, grammarAccess.getLogicAccess().getCommaKeyword_4());
            		
            // InternalSparrow.g:4767:3: ( (lv_mathSymbol_5_0= RULE_MATH_SYMBOL ) )
            // InternalSparrow.g:4768:4: (lv_mathSymbol_5_0= RULE_MATH_SYMBOL )
            {
            // InternalSparrow.g:4768:4: (lv_mathSymbol_5_0= RULE_MATH_SYMBOL )
            // InternalSparrow.g:4769:5: lv_mathSymbol_5_0= RULE_MATH_SYMBOL
            {
            lv_mathSymbol_5_0=(Token)match(input,RULE_MATH_SYMBOL,FOLLOW_64); 

            					newLeafNode(lv_mathSymbol_5_0, grammarAccess.getLogicAccess().getMathSymbolMATH_SYMBOLTerminalRuleCall_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLogicRule());
            					}
            					setWithLastConsumed(
            						current,
            						"mathSymbol",
            						lv_mathSymbol_5_0,
            						"org.xtext.example.mydsl.Sparrow.MATH_SYMBOL");
            				

            }


            }

            otherlv_6=(Token)match(input,39,FOLLOW_2); 

            			newLeafNode(otherlv_6, grammarAccess.getLogicAccess().getRightParenthesisKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulelogic"


    // $ANTLR start "entryRuleisTrue"
    // InternalSparrow.g:4793:1: entryRuleisTrue returns [EObject current=null] : iv_ruleisTrue= ruleisTrue EOF ;
    public final EObject entryRuleisTrue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleisTrue = null;


        try {
            // InternalSparrow.g:4793:47: (iv_ruleisTrue= ruleisTrue EOF )
            // InternalSparrow.g:4794:2: iv_ruleisTrue= ruleisTrue EOF
            {
             newCompositeNode(grammarAccess.getIsTrueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleisTrue=ruleisTrue();

            state._fsp--;

             current =iv_ruleisTrue; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleisTrue"


    // $ANTLR start "ruleisTrue"
    // InternalSparrow.g:4800:1: ruleisTrue returns [EObject current=null] : (otherlv_0= 'isTrue(' ( (lv_compare_1_0= ruleSingleExpression ) ) otherlv_2= ')' ) ;
    public final EObject ruleisTrue() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_compare_1_0 = null;



        	enterRule();

        try {
            // InternalSparrow.g:4806:2: ( (otherlv_0= 'isTrue(' ( (lv_compare_1_0= ruleSingleExpression ) ) otherlv_2= ')' ) )
            // InternalSparrow.g:4807:2: (otherlv_0= 'isTrue(' ( (lv_compare_1_0= ruleSingleExpression ) ) otherlv_2= ')' )
            {
            // InternalSparrow.g:4807:2: (otherlv_0= 'isTrue(' ( (lv_compare_1_0= ruleSingleExpression ) ) otherlv_2= ')' )
            // InternalSparrow.g:4808:3: otherlv_0= 'isTrue(' ( (lv_compare_1_0= ruleSingleExpression ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,93,FOLLOW_70); 

            			newLeafNode(otherlv_0, grammarAccess.getIsTrueAccess().getIsTrueKeyword_0());
            		
            // InternalSparrow.g:4812:3: ( (lv_compare_1_0= ruleSingleExpression ) )
            // InternalSparrow.g:4813:4: (lv_compare_1_0= ruleSingleExpression )
            {
            // InternalSparrow.g:4813:4: (lv_compare_1_0= ruleSingleExpression )
            // InternalSparrow.g:4814:5: lv_compare_1_0= ruleSingleExpression
            {

            					newCompositeNode(grammarAccess.getIsTrueAccess().getCompareSingleExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_64);
            lv_compare_1_0=ruleSingleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIsTrueRule());
            					}
            					set(
            						current,
            						"compare",
            						lv_compare_1_0,
            						"org.xtext.example.mydsl.Sparrow.SingleExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,39,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getIsTrueAccess().getRightParenthesisKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleisTrue"


    // $ANTLR start "entryRuleisDone"
    // InternalSparrow.g:4839:1: entryRuleisDone returns [EObject current=null] : iv_ruleisDone= ruleisDone EOF ;
    public final EObject entryRuleisDone() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleisDone = null;


        try {
            // InternalSparrow.g:4839:47: (iv_ruleisDone= ruleisDone EOF )
            // InternalSparrow.g:4840:2: iv_ruleisDone= ruleisDone EOF
            {
             newCompositeNode(grammarAccess.getIsDoneRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleisDone=ruleisDone();

            state._fsp--;

             current =iv_ruleisDone; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleisDone"


    // $ANTLR start "ruleisDone"
    // InternalSparrow.g:4846:1: ruleisDone returns [EObject current=null] : (otherlv_0= 'isDone(' ( (otherlv_1= RULE_ID ) ) otherlv_2= ')' ) ;
    public final EObject ruleisDone() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSparrow.g:4852:2: ( (otherlv_0= 'isDone(' ( (otherlv_1= RULE_ID ) ) otherlv_2= ')' ) )
            // InternalSparrow.g:4853:2: (otherlv_0= 'isDone(' ( (otherlv_1= RULE_ID ) ) otherlv_2= ')' )
            {
            // InternalSparrow.g:4853:2: (otherlv_0= 'isDone(' ( (otherlv_1= RULE_ID ) ) otherlv_2= ')' )
            // InternalSparrow.g:4854:3: otherlv_0= 'isDone(' ( (otherlv_1= RULE_ID ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,94,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getIsDoneAccess().getIsDoneKeyword_0());
            		
            // InternalSparrow.g:4858:3: ( (otherlv_1= RULE_ID ) )
            // InternalSparrow.g:4859:4: (otherlv_1= RULE_ID )
            {
            // InternalSparrow.g:4859:4: (otherlv_1= RULE_ID )
            // InternalSparrow.g:4860:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getIsDoneRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_64); 

            					newLeafNode(otherlv_1, grammarAccess.getIsDoneAccess().getNameRuleExpressionCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,39,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getIsDoneAccess().getRightParenthesisKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleisDone"


    // $ANTLR start "entryRulecheckExpression"
    // InternalSparrow.g:4879:1: entryRulecheckExpression returns [EObject current=null] : iv_rulecheckExpression= rulecheckExpression EOF ;
    public final EObject entryRulecheckExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulecheckExpression = null;


        try {
            // InternalSparrow.g:4879:56: (iv_rulecheckExpression= rulecheckExpression EOF )
            // InternalSparrow.g:4880:2: iv_rulecheckExpression= rulecheckExpression EOF
            {
             newCompositeNode(grammarAccess.getCheckExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_rulecheckExpression=rulecheckExpression();

            state._fsp--;

             current =iv_rulecheckExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulecheckExpression"


    // $ANTLR start "rulecheckExpression"
    // InternalSparrow.g:4886:1: rulecheckExpression returns [EObject current=null] : (otherlv_0= 'check(' ( (otherlv_1= RULE_ID ) ) otherlv_2= ')' ) ;
    public final EObject rulecheckExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSparrow.g:4892:2: ( (otherlv_0= 'check(' ( (otherlv_1= RULE_ID ) ) otherlv_2= ')' ) )
            // InternalSparrow.g:4893:2: (otherlv_0= 'check(' ( (otherlv_1= RULE_ID ) ) otherlv_2= ')' )
            {
            // InternalSparrow.g:4893:2: (otherlv_0= 'check(' ( (otherlv_1= RULE_ID ) ) otherlv_2= ')' )
            // InternalSparrow.g:4894:3: otherlv_0= 'check(' ( (otherlv_1= RULE_ID ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,95,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getCheckExpressionAccess().getCheckKeyword_0());
            		
            // InternalSparrow.g:4898:3: ( (otherlv_1= RULE_ID ) )
            // InternalSparrow.g:4899:4: (otherlv_1= RULE_ID )
            {
            // InternalSparrow.g:4899:4: (otherlv_1= RULE_ID )
            // InternalSparrow.g:4900:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getCheckExpressionRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_64); 

            					newLeafNode(otherlv_1, grammarAccess.getCheckExpressionAccess().getNameModelCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,39,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getCheckExpressionAccess().getRightParenthesisKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulecheckExpression"


    // $ANTLR start "entryRuleMixExpression"
    // InternalSparrow.g:4919:1: entryRuleMixExpression returns [EObject current=null] : iv_ruleMixExpression= ruleMixExpression EOF ;
    public final EObject entryRuleMixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMixExpression = null;


        try {
            // InternalSparrow.g:4919:54: (iv_ruleMixExpression= ruleMixExpression EOF )
            // InternalSparrow.g:4920:2: iv_ruleMixExpression= ruleMixExpression EOF
            {
             newCompositeNode(grammarAccess.getMixExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMixExpression=ruleMixExpression();

            state._fsp--;

             current =iv_ruleMixExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMixExpression"


    // $ANTLR start "ruleMixExpression"
    // InternalSparrow.g:4926:1: ruleMixExpression returns [EObject current=null] : ( ( (lv_expression_0_0= ruleSingleExpression ) ) ( (lv_otherMixExpression_1_0= ruleOtherMixExpression ) )* ) ;
    public final EObject ruleMixExpression() throws RecognitionException {
        EObject current = null;

        EObject lv_expression_0_0 = null;

        EObject lv_otherMixExpression_1_0 = null;



        	enterRule();

        try {
            // InternalSparrow.g:4932:2: ( ( ( (lv_expression_0_0= ruleSingleExpression ) ) ( (lv_otherMixExpression_1_0= ruleOtherMixExpression ) )* ) )
            // InternalSparrow.g:4933:2: ( ( (lv_expression_0_0= ruleSingleExpression ) ) ( (lv_otherMixExpression_1_0= ruleOtherMixExpression ) )* )
            {
            // InternalSparrow.g:4933:2: ( ( (lv_expression_0_0= ruleSingleExpression ) ) ( (lv_otherMixExpression_1_0= ruleOtherMixExpression ) )* )
            // InternalSparrow.g:4934:3: ( (lv_expression_0_0= ruleSingleExpression ) ) ( (lv_otherMixExpression_1_0= ruleOtherMixExpression ) )*
            {
            // InternalSparrow.g:4934:3: ( (lv_expression_0_0= ruleSingleExpression ) )
            // InternalSparrow.g:4935:4: (lv_expression_0_0= ruleSingleExpression )
            {
            // InternalSparrow.g:4935:4: (lv_expression_0_0= ruleSingleExpression )
            // InternalSparrow.g:4936:5: lv_expression_0_0= ruleSingleExpression
            {

            					newCompositeNode(grammarAccess.getMixExpressionAccess().getExpressionSingleExpressionParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_77);
            lv_expression_0_0=ruleSingleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMixExpressionRule());
            					}
            					set(
            						current,
            						"expression",
            						lv_expression_0_0,
            						"org.xtext.example.mydsl.Sparrow.SingleExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSparrow.g:4953:3: ( (lv_otherMixExpression_1_0= ruleOtherMixExpression ) )*
            loop85:
            do {
                int alt85=2;
                alt85 = dfa85.predict(input);
                switch (alt85) {
            	case 1 :
            	    // InternalSparrow.g:4954:4: (lv_otherMixExpression_1_0= ruleOtherMixExpression )
            	    {
            	    // InternalSparrow.g:4954:4: (lv_otherMixExpression_1_0= ruleOtherMixExpression )
            	    // InternalSparrow.g:4955:5: lv_otherMixExpression_1_0= ruleOtherMixExpression
            	    {

            	    					newCompositeNode(grammarAccess.getMixExpressionAccess().getOtherMixExpressionOtherMixExpressionParserRuleCall_1_0());
            	    				
            	    pushFollow(FOLLOW_77);
            	    lv_otherMixExpression_1_0=ruleOtherMixExpression();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getMixExpressionRule());
            	    					}
            	    					add(
            	    						current,
            	    						"otherMixExpression",
            	    						lv_otherMixExpression_1_0,
            	    						"org.xtext.example.mydsl.Sparrow.OtherMixExpression");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop85;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMixExpression"


    // $ANTLR start "entryRuleOtherMixExpression"
    // InternalSparrow.g:4976:1: entryRuleOtherMixExpression returns [EObject current=null] : iv_ruleOtherMixExpression= ruleOtherMixExpression EOF ;
    public final EObject entryRuleOtherMixExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOtherMixExpression = null;


        try {
            // InternalSparrow.g:4976:59: (iv_ruleOtherMixExpression= ruleOtherMixExpression EOF )
            // InternalSparrow.g:4977:2: iv_ruleOtherMixExpression= ruleOtherMixExpression EOF
            {
             newCompositeNode(grammarAccess.getOtherMixExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOtherMixExpression=ruleOtherMixExpression();

            state._fsp--;

             current =iv_ruleOtherMixExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOtherMixExpression"


    // $ANTLR start "ruleOtherMixExpression"
    // InternalSparrow.g:4983:1: ruleOtherMixExpression returns [EObject current=null] : ( ( (lv_link_0_0= RULE_ARITHMETIC_OPERATOR ) ) ( (lv_expression_1_0= ruleSingleExpression ) ) ) ;
    public final EObject ruleOtherMixExpression() throws RecognitionException {
        EObject current = null;

        Token lv_link_0_0=null;
        EObject lv_expression_1_0 = null;



        	enterRule();

        try {
            // InternalSparrow.g:4989:2: ( ( ( (lv_link_0_0= RULE_ARITHMETIC_OPERATOR ) ) ( (lv_expression_1_0= ruleSingleExpression ) ) ) )
            // InternalSparrow.g:4990:2: ( ( (lv_link_0_0= RULE_ARITHMETIC_OPERATOR ) ) ( (lv_expression_1_0= ruleSingleExpression ) ) )
            {
            // InternalSparrow.g:4990:2: ( ( (lv_link_0_0= RULE_ARITHMETIC_OPERATOR ) ) ( (lv_expression_1_0= ruleSingleExpression ) ) )
            // InternalSparrow.g:4991:3: ( (lv_link_0_0= RULE_ARITHMETIC_OPERATOR ) ) ( (lv_expression_1_0= ruleSingleExpression ) )
            {
            // InternalSparrow.g:4991:3: ( (lv_link_0_0= RULE_ARITHMETIC_OPERATOR ) )
            // InternalSparrow.g:4992:4: (lv_link_0_0= RULE_ARITHMETIC_OPERATOR )
            {
            // InternalSparrow.g:4992:4: (lv_link_0_0= RULE_ARITHMETIC_OPERATOR )
            // InternalSparrow.g:4993:5: lv_link_0_0= RULE_ARITHMETIC_OPERATOR
            {
            lv_link_0_0=(Token)match(input,RULE_ARITHMETIC_OPERATOR,FOLLOW_70); 

            					newLeafNode(lv_link_0_0, grammarAccess.getOtherMixExpressionAccess().getLinkARITHMETIC_OPERATORTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOtherMixExpressionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"link",
            						lv_link_0_0,
            						"org.xtext.example.mydsl.Sparrow.ARITHMETIC_OPERATOR");
            				

            }


            }

            // InternalSparrow.g:5009:3: ( (lv_expression_1_0= ruleSingleExpression ) )
            // InternalSparrow.g:5010:4: (lv_expression_1_0= ruleSingleExpression )
            {
            // InternalSparrow.g:5010:4: (lv_expression_1_0= ruleSingleExpression )
            // InternalSparrow.g:5011:5: lv_expression_1_0= ruleSingleExpression
            {

            					newCompositeNode(grammarAccess.getOtherMixExpressionAccess().getExpressionSingleExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_expression_1_0=ruleSingleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOtherMixExpressionRule());
            					}
            					set(
            						current,
            						"expression",
            						lv_expression_1_0,
            						"org.xtext.example.mydsl.Sparrow.SingleExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOtherMixExpression"


    // $ANTLR start "entryRuleSingleExpression"
    // InternalSparrow.g:5032:1: entryRuleSingleExpression returns [EObject current=null] : iv_ruleSingleExpression= ruleSingleExpression EOF ;
    public final EObject entryRuleSingleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSingleExpression = null;


        try {
            // InternalSparrow.g:5032:57: (iv_ruleSingleExpression= ruleSingleExpression EOF )
            // InternalSparrow.g:5033:2: iv_ruleSingleExpression= ruleSingleExpression EOF
            {
             newCompositeNode(grammarAccess.getSingleExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSingleExpression=ruleSingleExpression();

            state._fsp--;

             current =iv_ruleSingleExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSingleExpression"


    // $ANTLR start "ruleSingleExpression"
    // InternalSparrow.g:5039:1: ruleSingleExpression returns [EObject current=null] : (this_RegularExpression_0= ruleRegularExpression | this_ThingExpression_1= ruleThingExpression | this_OtherExpression_2= ruleOtherExpression | this_PersonExpression_3= rulePersonExpression | this_RuleTimeExpression_4= ruleRuleTimeExpression | this_FloatExpression_5= ruleFloatExpression | this_StringExpression_6= ruleStringExpression | this_PeriodExpression_7= rulePeriodExpression | this_GetPeriodExpression_8= ruleGetPeriodExpression ) ;
    public final EObject ruleSingleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_RegularExpression_0 = null;

        EObject this_ThingExpression_1 = null;

        EObject this_OtherExpression_2 = null;

        EObject this_PersonExpression_3 = null;

        EObject this_RuleTimeExpression_4 = null;

        EObject this_FloatExpression_5 = null;

        EObject this_StringExpression_6 = null;

        EObject this_PeriodExpression_7 = null;

        EObject this_GetPeriodExpression_8 = null;



        	enterRule();

        try {
            // InternalSparrow.g:5045:2: ( (this_RegularExpression_0= ruleRegularExpression | this_ThingExpression_1= ruleThingExpression | this_OtherExpression_2= ruleOtherExpression | this_PersonExpression_3= rulePersonExpression | this_RuleTimeExpression_4= ruleRuleTimeExpression | this_FloatExpression_5= ruleFloatExpression | this_StringExpression_6= ruleStringExpression | this_PeriodExpression_7= rulePeriodExpression | this_GetPeriodExpression_8= ruleGetPeriodExpression ) )
            // InternalSparrow.g:5046:2: (this_RegularExpression_0= ruleRegularExpression | this_ThingExpression_1= ruleThingExpression | this_OtherExpression_2= ruleOtherExpression | this_PersonExpression_3= rulePersonExpression | this_RuleTimeExpression_4= ruleRuleTimeExpression | this_FloatExpression_5= ruleFloatExpression | this_StringExpression_6= ruleStringExpression | this_PeriodExpression_7= rulePeriodExpression | this_GetPeriodExpression_8= ruleGetPeriodExpression )
            {
            // InternalSparrow.g:5046:2: (this_RegularExpression_0= ruleRegularExpression | this_ThingExpression_1= ruleThingExpression | this_OtherExpression_2= ruleOtherExpression | this_PersonExpression_3= rulePersonExpression | this_RuleTimeExpression_4= ruleRuleTimeExpression | this_FloatExpression_5= ruleFloatExpression | this_StringExpression_6= ruleStringExpression | this_PeriodExpression_7= rulePeriodExpression | this_GetPeriodExpression_8= ruleGetPeriodExpression )
            int alt86=9;
            alt86 = dfa86.predict(input);
            switch (alt86) {
                case 1 :
                    // InternalSparrow.g:5047:3: this_RegularExpression_0= ruleRegularExpression
                    {

                    			newCompositeNode(grammarAccess.getSingleExpressionAccess().getRegularExpressionParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_RegularExpression_0=ruleRegularExpression();

                    state._fsp--;


                    			current = this_RegularExpression_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalSparrow.g:5056:3: this_ThingExpression_1= ruleThingExpression
                    {

                    			newCompositeNode(grammarAccess.getSingleExpressionAccess().getThingExpressionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ThingExpression_1=ruleThingExpression();

                    state._fsp--;


                    			current = this_ThingExpression_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalSparrow.g:5065:3: this_OtherExpression_2= ruleOtherExpression
                    {

                    			newCompositeNode(grammarAccess.getSingleExpressionAccess().getOtherExpressionParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_OtherExpression_2=ruleOtherExpression();

                    state._fsp--;


                    			current = this_OtherExpression_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalSparrow.g:5074:3: this_PersonExpression_3= rulePersonExpression
                    {

                    			newCompositeNode(grammarAccess.getSingleExpressionAccess().getPersonExpressionParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_PersonExpression_3=rulePersonExpression();

                    state._fsp--;


                    			current = this_PersonExpression_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalSparrow.g:5083:3: this_RuleTimeExpression_4= ruleRuleTimeExpression
                    {

                    			newCompositeNode(grammarAccess.getSingleExpressionAccess().getRuleTimeExpressionParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_RuleTimeExpression_4=ruleRuleTimeExpression();

                    state._fsp--;


                    			current = this_RuleTimeExpression_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalSparrow.g:5092:3: this_FloatExpression_5= ruleFloatExpression
                    {

                    			newCompositeNode(grammarAccess.getSingleExpressionAccess().getFloatExpressionParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_FloatExpression_5=ruleFloatExpression();

                    state._fsp--;


                    			current = this_FloatExpression_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalSparrow.g:5101:3: this_StringExpression_6= ruleStringExpression
                    {

                    			newCompositeNode(grammarAccess.getSingleExpressionAccess().getStringExpressionParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_StringExpression_6=ruleStringExpression();

                    state._fsp--;


                    			current = this_StringExpression_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 8 :
                    // InternalSparrow.g:5110:3: this_PeriodExpression_7= rulePeriodExpression
                    {

                    			newCompositeNode(grammarAccess.getSingleExpressionAccess().getPeriodExpressionParserRuleCall_7());
                    		
                    pushFollow(FOLLOW_2);
                    this_PeriodExpression_7=rulePeriodExpression();

                    state._fsp--;


                    			current = this_PeriodExpression_7;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 9 :
                    // InternalSparrow.g:5119:3: this_GetPeriodExpression_8= ruleGetPeriodExpression
                    {

                    			newCompositeNode(grammarAccess.getSingleExpressionAccess().getGetPeriodExpressionParserRuleCall_8());
                    		
                    pushFollow(FOLLOW_2);
                    this_GetPeriodExpression_8=ruleGetPeriodExpression();

                    state._fsp--;


                    			current = this_GetPeriodExpression_8;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSingleExpression"


    // $ANTLR start "entryRulePeriodExpression"
    // InternalSparrow.g:5131:1: entryRulePeriodExpression returns [EObject current=null] : iv_rulePeriodExpression= rulePeriodExpression EOF ;
    public final EObject entryRulePeriodExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePeriodExpression = null;


        try {
            // InternalSparrow.g:5131:57: (iv_rulePeriodExpression= rulePeriodExpression EOF )
            // InternalSparrow.g:5132:2: iv_rulePeriodExpression= rulePeriodExpression EOF
            {
             newCompositeNode(grammarAccess.getPeriodExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePeriodExpression=rulePeriodExpression();

            state._fsp--;

             current =iv_rulePeriodExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePeriodExpression"


    // $ANTLR start "rulePeriodExpression"
    // InternalSparrow.g:5138:1: rulePeriodExpression returns [EObject current=null] : ( ( (lv_value_0_0= RULE_INT ) ) ( (lv_type_1_0= ruleEachTime ) ) ) ;
    public final EObject rulePeriodExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;
        AntlrDatatypeRuleToken lv_type_1_0 = null;



        	enterRule();

        try {
            // InternalSparrow.g:5144:2: ( ( ( (lv_value_0_0= RULE_INT ) ) ( (lv_type_1_0= ruleEachTime ) ) ) )
            // InternalSparrow.g:5145:2: ( ( (lv_value_0_0= RULE_INT ) ) ( (lv_type_1_0= ruleEachTime ) ) )
            {
            // InternalSparrow.g:5145:2: ( ( (lv_value_0_0= RULE_INT ) ) ( (lv_type_1_0= ruleEachTime ) ) )
            // InternalSparrow.g:5146:3: ( (lv_value_0_0= RULE_INT ) ) ( (lv_type_1_0= ruleEachTime ) )
            {
            // InternalSparrow.g:5146:3: ( (lv_value_0_0= RULE_INT ) )
            // InternalSparrow.g:5147:4: (lv_value_0_0= RULE_INT )
            {
            // InternalSparrow.g:5147:4: (lv_value_0_0= RULE_INT )
            // InternalSparrow.g:5148:5: lv_value_0_0= RULE_INT
            {
            lv_value_0_0=(Token)match(input,RULE_INT,FOLLOW_28); 

            					newLeafNode(lv_value_0_0, grammarAccess.getPeriodExpressionAccess().getValueINTTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPeriodExpressionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_0_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            // InternalSparrow.g:5164:3: ( (lv_type_1_0= ruleEachTime ) )
            // InternalSparrow.g:5165:4: (lv_type_1_0= ruleEachTime )
            {
            // InternalSparrow.g:5165:4: (lv_type_1_0= ruleEachTime )
            // InternalSparrow.g:5166:5: lv_type_1_0= ruleEachTime
            {

            					newCompositeNode(grammarAccess.getPeriodExpressionAccess().getTypeEachTimeParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_type_1_0=ruleEachTime();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPeriodExpressionRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_1_0,
            						"org.xtext.example.mydsl.Sparrow.EachTime");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePeriodExpression"


    // $ANTLR start "entryRuleGetPeriodExpression"
    // InternalSparrow.g:5187:1: entryRuleGetPeriodExpression returns [EObject current=null] : iv_ruleGetPeriodExpression= ruleGetPeriodExpression EOF ;
    public final EObject entryRuleGetPeriodExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleGetPeriodExpression = null;


        try {
            // InternalSparrow.g:5187:60: (iv_ruleGetPeriodExpression= ruleGetPeriodExpression EOF )
            // InternalSparrow.g:5188:2: iv_ruleGetPeriodExpression= ruleGetPeriodExpression EOF
            {
             newCompositeNode(grammarAccess.getGetPeriodExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleGetPeriodExpression=ruleGetPeriodExpression();

            state._fsp--;

             current =iv_ruleGetPeriodExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleGetPeriodExpression"


    // $ANTLR start "ruleGetPeriodExpression"
    // InternalSparrow.g:5194:1: ruleGetPeriodExpression returns [EObject current=null] : ( ( (lv_value_0_0= RULE_ID ) ) ( (lv_type_1_0= ruleEachTime ) ) ) ;
    public final EObject ruleGetPeriodExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;
        AntlrDatatypeRuleToken lv_type_1_0 = null;



        	enterRule();

        try {
            // InternalSparrow.g:5200:2: ( ( ( (lv_value_0_0= RULE_ID ) ) ( (lv_type_1_0= ruleEachTime ) ) ) )
            // InternalSparrow.g:5201:2: ( ( (lv_value_0_0= RULE_ID ) ) ( (lv_type_1_0= ruleEachTime ) ) )
            {
            // InternalSparrow.g:5201:2: ( ( (lv_value_0_0= RULE_ID ) ) ( (lv_type_1_0= ruleEachTime ) ) )
            // InternalSparrow.g:5202:3: ( (lv_value_0_0= RULE_ID ) ) ( (lv_type_1_0= ruleEachTime ) )
            {
            // InternalSparrow.g:5202:3: ( (lv_value_0_0= RULE_ID ) )
            // InternalSparrow.g:5203:4: (lv_value_0_0= RULE_ID )
            {
            // InternalSparrow.g:5203:4: (lv_value_0_0= RULE_ID )
            // InternalSparrow.g:5204:5: lv_value_0_0= RULE_ID
            {
            lv_value_0_0=(Token)match(input,RULE_ID,FOLLOW_28); 

            					newLeafNode(lv_value_0_0, grammarAccess.getGetPeriodExpressionAccess().getValueIDTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getGetPeriodExpressionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_0_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalSparrow.g:5220:3: ( (lv_type_1_0= ruleEachTime ) )
            // InternalSparrow.g:5221:4: (lv_type_1_0= ruleEachTime )
            {
            // InternalSparrow.g:5221:4: (lv_type_1_0= ruleEachTime )
            // InternalSparrow.g:5222:5: lv_type_1_0= ruleEachTime
            {

            					newCompositeNode(grammarAccess.getGetPeriodExpressionAccess().getTypeEachTimeParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_type_1_0=ruleEachTime();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getGetPeriodExpressionRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_1_0,
            						"org.xtext.example.mydsl.Sparrow.EachTime");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleGetPeriodExpression"


    // $ANTLR start "entryRuleRuleTimeExpression"
    // InternalSparrow.g:5243:1: entryRuleRuleTimeExpression returns [EObject current=null] : iv_ruleRuleTimeExpression= ruleRuleTimeExpression EOF ;
    public final EObject entryRuleRuleTimeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleTimeExpression = null;


        try {
            // InternalSparrow.g:5243:59: (iv_ruleRuleTimeExpression= ruleRuleTimeExpression EOF )
            // InternalSparrow.g:5244:2: iv_ruleRuleTimeExpression= ruleRuleTimeExpression EOF
            {
             newCompositeNode(grammarAccess.getRuleTimeExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRuleTimeExpression=ruleRuleTimeExpression();

            state._fsp--;

             current =iv_ruleRuleTimeExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRuleTimeExpression"


    // $ANTLR start "ruleRuleTimeExpression"
    // InternalSparrow.g:5250:1: ruleRuleTimeExpression returns [EObject current=null] : (otherlv_0= 'getRuleTime(' ( (otherlv_1= RULE_ID ) ) otherlv_2= ')' ) ;
    public final EObject ruleRuleTimeExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSparrow.g:5256:2: ( (otherlv_0= 'getRuleTime(' ( (otherlv_1= RULE_ID ) ) otherlv_2= ')' ) )
            // InternalSparrow.g:5257:2: (otherlv_0= 'getRuleTime(' ( (otherlv_1= RULE_ID ) ) otherlv_2= ')' )
            {
            // InternalSparrow.g:5257:2: (otherlv_0= 'getRuleTime(' ( (otherlv_1= RULE_ID ) ) otherlv_2= ')' )
            // InternalSparrow.g:5258:3: otherlv_0= 'getRuleTime(' ( (otherlv_1= RULE_ID ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,96,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getRuleTimeExpressionAccess().getGetRuleTimeKeyword_0());
            		
            // InternalSparrow.g:5262:3: ( (otherlv_1= RULE_ID ) )
            // InternalSparrow.g:5263:4: (otherlv_1= RULE_ID )
            {
            // InternalSparrow.g:5263:4: (otherlv_1= RULE_ID )
            // InternalSparrow.g:5264:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRuleTimeExpressionRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_64); 

            					newLeafNode(otherlv_1, grammarAccess.getRuleTimeExpressionAccess().getValueRuleExpressionCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,39,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getRuleTimeExpressionAccess().getRightParenthesisKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRuleTimeExpression"


    // $ANTLR start "entryRuleOtherExpression"
    // InternalSparrow.g:5283:1: entryRuleOtherExpression returns [EObject current=null] : iv_ruleOtherExpression= ruleOtherExpression EOF ;
    public final EObject entryRuleOtherExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOtherExpression = null;


        try {
            // InternalSparrow.g:5283:56: (iv_ruleOtherExpression= ruleOtherExpression EOF )
            // InternalSparrow.g:5284:2: iv_ruleOtherExpression= ruleOtherExpression EOF
            {
             newCompositeNode(grammarAccess.getOtherExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOtherExpression=ruleOtherExpression();

            state._fsp--;

             current =iv_ruleOtherExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOtherExpression"


    // $ANTLR start "ruleOtherExpression"
    // InternalSparrow.g:5290:1: ruleOtherExpression returns [EObject current=null] : ( (lv_value_0_0= RULE_ID ) ) ;
    public final EObject ruleOtherExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalSparrow.g:5296:2: ( ( (lv_value_0_0= RULE_ID ) ) )
            // InternalSparrow.g:5297:2: ( (lv_value_0_0= RULE_ID ) )
            {
            // InternalSparrow.g:5297:2: ( (lv_value_0_0= RULE_ID ) )
            // InternalSparrow.g:5298:3: (lv_value_0_0= RULE_ID )
            {
            // InternalSparrow.g:5298:3: (lv_value_0_0= RULE_ID )
            // InternalSparrow.g:5299:4: lv_value_0_0= RULE_ID
            {
            lv_value_0_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            				newLeafNode(lv_value_0_0, grammarAccess.getOtherExpressionAccess().getValueIDTerminalRuleCall_0());
            			

            				if (current==null) {
            					current = createModelElement(grammarAccess.getOtherExpressionRule());
            				}
            				setWithLastConsumed(
            					current,
            					"value",
            					lv_value_0_0,
            					"org.eclipse.xtext.common.Terminals.ID");
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOtherExpression"


    // $ANTLR start "entryRuleStringExpression"
    // InternalSparrow.g:5318:1: entryRuleStringExpression returns [EObject current=null] : iv_ruleStringExpression= ruleStringExpression EOF ;
    public final EObject entryRuleStringExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringExpression = null;


        try {
            // InternalSparrow.g:5318:57: (iv_ruleStringExpression= ruleStringExpression EOF )
            // InternalSparrow.g:5319:2: iv_ruleStringExpression= ruleStringExpression EOF
            {
             newCompositeNode(grammarAccess.getStringExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStringExpression=ruleStringExpression();

            state._fsp--;

             current =iv_ruleStringExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStringExpression"


    // $ANTLR start "ruleStringExpression"
    // InternalSparrow.g:5325:1: ruleStringExpression returns [EObject current=null] : (otherlv_0= '\"' ( (lv_value_1_0= RULE_ID ) ) otherlv_2= '\"' ) ;
    public final EObject ruleStringExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_value_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalSparrow.g:5331:2: ( (otherlv_0= '\"' ( (lv_value_1_0= RULE_ID ) ) otherlv_2= '\"' ) )
            // InternalSparrow.g:5332:2: (otherlv_0= '\"' ( (lv_value_1_0= RULE_ID ) ) otherlv_2= '\"' )
            {
            // InternalSparrow.g:5332:2: (otherlv_0= '\"' ( (lv_value_1_0= RULE_ID ) ) otherlv_2= '\"' )
            // InternalSparrow.g:5333:3: otherlv_0= '\"' ( (lv_value_1_0= RULE_ID ) ) otherlv_2= '\"'
            {
            otherlv_0=(Token)match(input,97,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getStringExpressionAccess().getQuotationMarkKeyword_0());
            		
            // InternalSparrow.g:5337:3: ( (lv_value_1_0= RULE_ID ) )
            // InternalSparrow.g:5338:4: (lv_value_1_0= RULE_ID )
            {
            // InternalSparrow.g:5338:4: (lv_value_1_0= RULE_ID )
            // InternalSparrow.g:5339:5: lv_value_1_0= RULE_ID
            {
            lv_value_1_0=(Token)match(input,RULE_ID,FOLLOW_78); 

            					newLeafNode(lv_value_1_0, grammarAccess.getStringExpressionAccess().getValueIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStringExpressionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,97,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getStringExpressionAccess().getQuotationMarkKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStringExpression"


    // $ANTLR start "entryRuleFloatExpression"
    // InternalSparrow.g:5363:1: entryRuleFloatExpression returns [EObject current=null] : iv_ruleFloatExpression= ruleFloatExpression EOF ;
    public final EObject entryRuleFloatExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFloatExpression = null;


        try {
            // InternalSparrow.g:5363:56: (iv_ruleFloatExpression= ruleFloatExpression EOF )
            // InternalSparrow.g:5364:2: iv_ruleFloatExpression= ruleFloatExpression EOF
            {
             newCompositeNode(grammarAccess.getFloatExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFloatExpression=ruleFloatExpression();

            state._fsp--;

             current =iv_ruleFloatExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFloatExpression"


    // $ANTLR start "ruleFloatExpression"
    // InternalSparrow.g:5370:1: ruleFloatExpression returns [EObject current=null] : (otherlv_0= 'f' ( (lv_value_1_0= RULE_ID ) ) ) ;
    public final EObject ruleFloatExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_value_1_0=null;


        	enterRule();

        try {
            // InternalSparrow.g:5376:2: ( (otherlv_0= 'f' ( (lv_value_1_0= RULE_ID ) ) ) )
            // InternalSparrow.g:5377:2: (otherlv_0= 'f' ( (lv_value_1_0= RULE_ID ) ) )
            {
            // InternalSparrow.g:5377:2: (otherlv_0= 'f' ( (lv_value_1_0= RULE_ID ) ) )
            // InternalSparrow.g:5378:3: otherlv_0= 'f' ( (lv_value_1_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,98,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getFloatExpressionAccess().getFKeyword_0());
            		
            // InternalSparrow.g:5382:3: ( (lv_value_1_0= RULE_ID ) )
            // InternalSparrow.g:5383:4: (lv_value_1_0= RULE_ID )
            {
            // InternalSparrow.g:5383:4: (lv_value_1_0= RULE_ID )
            // InternalSparrow.g:5384:5: lv_value_1_0= RULE_ID
            {
            lv_value_1_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_value_1_0, grammarAccess.getFloatExpressionAccess().getValueIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFloatExpressionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"value",
            						lv_value_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFloatExpression"


    // $ANTLR start "entryRulePersonExpression"
    // InternalSparrow.g:5404:1: entryRulePersonExpression returns [EObject current=null] : iv_rulePersonExpression= rulePersonExpression EOF ;
    public final EObject entryRulePersonExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePersonExpression = null;


        try {
            // InternalSparrow.g:5404:57: (iv_rulePersonExpression= rulePersonExpression EOF )
            // InternalSparrow.g:5405:2: iv_rulePersonExpression= rulePersonExpression EOF
            {
             newCompositeNode(grammarAccess.getPersonExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePersonExpression=rulePersonExpression();

            state._fsp--;

             current =iv_rulePersonExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePersonExpression"


    // $ANTLR start "rulePersonExpression"
    // InternalSparrow.g:5411:1: rulePersonExpression returns [EObject current=null] : (otherlv_0= 'p' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject rulePersonExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalSparrow.g:5417:2: ( (otherlv_0= 'p' ( (otherlv_1= RULE_ID ) ) ) )
            // InternalSparrow.g:5418:2: (otherlv_0= 'p' ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalSparrow.g:5418:2: (otherlv_0= 'p' ( (otherlv_1= RULE_ID ) ) )
            // InternalSparrow.g:5419:3: otherlv_0= 'p' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,99,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getPersonExpressionAccess().getPKeyword_0());
            		
            // InternalSparrow.g:5423:3: ( (otherlv_1= RULE_ID ) )
            // InternalSparrow.g:5424:4: (otherlv_1= RULE_ID )
            {
            // InternalSparrow.g:5424:4: (otherlv_1= RULE_ID )
            // InternalSparrow.g:5425:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPersonExpressionRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(otherlv_1, grammarAccess.getPersonExpressionAccess().getValueInitExpressionsCrossReference_1_0());
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePersonExpression"


    // $ANTLR start "entryRuleRegularExpression"
    // InternalSparrow.g:5440:1: entryRuleRegularExpression returns [EObject current=null] : iv_ruleRegularExpression= ruleRegularExpression EOF ;
    public final EObject entryRuleRegularExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegularExpression = null;


        try {
            // InternalSparrow.g:5440:58: (iv_ruleRegularExpression= ruleRegularExpression EOF )
            // InternalSparrow.g:5441:2: iv_ruleRegularExpression= ruleRegularExpression EOF
            {
             newCompositeNode(grammarAccess.getRegularExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRegularExpression=ruleRegularExpression();

            state._fsp--;

             current =iv_ruleRegularExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRegularExpression"


    // $ANTLR start "ruleRegularExpression"
    // InternalSparrow.g:5447:1: ruleRegularExpression returns [EObject current=null] : (this_AllNumber_0= ruleAllNumber | this_ThisDecimal_1= ruleThisDecimal | this_ThisBoolean_2= ruleThisBoolean | this_Now_3= ruleNow | this_ThisDate_4= ruleThisDate ) ;
    public final EObject ruleRegularExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AllNumber_0 = null;

        EObject this_ThisDecimal_1 = null;

        EObject this_ThisBoolean_2 = null;

        EObject this_Now_3 = null;

        EObject this_ThisDate_4 = null;



        	enterRule();

        try {
            // InternalSparrow.g:5453:2: ( (this_AllNumber_0= ruleAllNumber | this_ThisDecimal_1= ruleThisDecimal | this_ThisBoolean_2= ruleThisBoolean | this_Now_3= ruleNow | this_ThisDate_4= ruleThisDate ) )
            // InternalSparrow.g:5454:2: (this_AllNumber_0= ruleAllNumber | this_ThisDecimal_1= ruleThisDecimal | this_ThisBoolean_2= ruleThisBoolean | this_Now_3= ruleNow | this_ThisDate_4= ruleThisDate )
            {
            // InternalSparrow.g:5454:2: (this_AllNumber_0= ruleAllNumber | this_ThisDecimal_1= ruleThisDecimal | this_ThisBoolean_2= ruleThisBoolean | this_Now_3= ruleNow | this_ThisDate_4= ruleThisDate )
            int alt87=5;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                int LA87_1 = input.LA(2);

                if ( (LA87_1==EOF||LA87_1==RULE_ARITHMETIC_OPERATOR||LA87_1==22||LA87_1==39||LA87_1==90) ) {
                    alt87=1;
                }
                else if ( (LA87_1==64) ) {
                    alt87=5;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 87, 1, input);

                    throw nvae;
                }
                }
                break;
            case RULE_DECIMAL:
                {
                alt87=2;
                }
                break;
            case 116:
            case 117:
                {
                alt87=3;
                }
                break;
            case 62:
                {
                alt87=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 87, 0, input);

                throw nvae;
            }

            switch (alt87) {
                case 1 :
                    // InternalSparrow.g:5455:3: this_AllNumber_0= ruleAllNumber
                    {

                    			newCompositeNode(grammarAccess.getRegularExpressionAccess().getAllNumberParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_AllNumber_0=ruleAllNumber();

                    state._fsp--;


                    			current = this_AllNumber_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalSparrow.g:5464:3: this_ThisDecimal_1= ruleThisDecimal
                    {

                    			newCompositeNode(grammarAccess.getRegularExpressionAccess().getThisDecimalParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_ThisDecimal_1=ruleThisDecimal();

                    state._fsp--;


                    			current = this_ThisDecimal_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalSparrow.g:5473:3: this_ThisBoolean_2= ruleThisBoolean
                    {

                    			newCompositeNode(grammarAccess.getRegularExpressionAccess().getThisBooleanParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_ThisBoolean_2=ruleThisBoolean();

                    state._fsp--;


                    			current = this_ThisBoolean_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalSparrow.g:5482:3: this_Now_3= ruleNow
                    {

                    			newCompositeNode(grammarAccess.getRegularExpressionAccess().getNowParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_Now_3=ruleNow();

                    state._fsp--;


                    			current = this_Now_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalSparrow.g:5491:3: this_ThisDate_4= ruleThisDate
                    {

                    			newCompositeNode(grammarAccess.getRegularExpressionAccess().getThisDateParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_ThisDate_4=ruleThisDate();

                    state._fsp--;


                    			current = this_ThisDate_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRegularExpression"


    // $ANTLR start "entryRuleThingExpression"
    // InternalSparrow.g:5503:1: entryRuleThingExpression returns [EObject current=null] : iv_ruleThingExpression= ruleThingExpression EOF ;
    public final EObject entryRuleThingExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleThingExpression = null;


        try {
            // InternalSparrow.g:5503:56: (iv_ruleThingExpression= ruleThingExpression EOF )
            // InternalSparrow.g:5504:2: iv_ruleThingExpression= ruleThingExpression EOF
            {
             newCompositeNode(grammarAccess.getThingExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleThingExpression=ruleThingExpression();

            state._fsp--;

             current =iv_ruleThingExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleThingExpression"


    // $ANTLR start "ruleThingExpression"
    // InternalSparrow.g:5510:1: ruleThingExpression returns [EObject current=null] : (this_ObjectExpress_0= ruleObjectExpress | this_SubjectExpress_1= ruleSubjectExpress ) ;
    public final EObject ruleThingExpression() throws RecognitionException {
        EObject current = null;

        EObject this_ObjectExpress_0 = null;

        EObject this_SubjectExpress_1 = null;



        	enterRule();

        try {
            // InternalSparrow.g:5516:2: ( (this_ObjectExpress_0= ruleObjectExpress | this_SubjectExpress_1= ruleSubjectExpress ) )
            // InternalSparrow.g:5517:2: (this_ObjectExpress_0= ruleObjectExpress | this_SubjectExpress_1= ruleSubjectExpress )
            {
            // InternalSparrow.g:5517:2: (this_ObjectExpress_0= ruleObjectExpress | this_SubjectExpress_1= ruleSubjectExpress )
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==102) ) {
                alt88=1;
            }
            else if ( (LA88_0==100) ) {
                alt88=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 88, 0, input);

                throw nvae;
            }
            switch (alt88) {
                case 1 :
                    // InternalSparrow.g:5518:3: this_ObjectExpress_0= ruleObjectExpress
                    {

                    			newCompositeNode(grammarAccess.getThingExpressionAccess().getObjectExpressParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_ObjectExpress_0=ruleObjectExpress();

                    state._fsp--;


                    			current = this_ObjectExpress_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalSparrow.g:5527:3: this_SubjectExpress_1= ruleSubjectExpress
                    {

                    			newCompositeNode(grammarAccess.getThingExpressionAccess().getSubjectExpressParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_SubjectExpress_1=ruleSubjectExpress();

                    state._fsp--;


                    			current = this_SubjectExpress_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleThingExpression"


    // $ANTLR start "entryRuleSubjectExpress"
    // InternalSparrow.g:5539:1: entryRuleSubjectExpress returns [EObject current=null] : iv_ruleSubjectExpress= ruleSubjectExpress EOF ;
    public final EObject entryRuleSubjectExpress() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSubjectExpress = null;


        try {
            // InternalSparrow.g:5539:55: (iv_ruleSubjectExpress= ruleSubjectExpress EOF )
            // InternalSparrow.g:5540:2: iv_ruleSubjectExpress= ruleSubjectExpress EOF
            {
             newCompositeNode(grammarAccess.getSubjectExpressRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSubjectExpress=ruleSubjectExpress();

            state._fsp--;

             current =iv_ruleSubjectExpress; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleSubjectExpress"


    // $ANTLR start "ruleSubjectExpress"
    // InternalSparrow.g:5546:1: ruleSubjectExpress returns [EObject current=null] : (otherlv_0= 's' ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (lv_attribute_3_0= RULE_ID ) ) ) ;
    public final EObject ruleSubjectExpress() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_attribute_3_0=null;


        	enterRule();

        try {
            // InternalSparrow.g:5552:2: ( (otherlv_0= 's' ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (lv_attribute_3_0= RULE_ID ) ) ) )
            // InternalSparrow.g:5553:2: (otherlv_0= 's' ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (lv_attribute_3_0= RULE_ID ) ) )
            {
            // InternalSparrow.g:5553:2: (otherlv_0= 's' ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (lv_attribute_3_0= RULE_ID ) ) )
            // InternalSparrow.g:5554:3: otherlv_0= 's' ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (lv_attribute_3_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,100,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getSubjectExpressAccess().getSKeyword_0());
            		
            // InternalSparrow.g:5558:3: ( (otherlv_1= RULE_ID ) )
            // InternalSparrow.g:5559:4: (otherlv_1= RULE_ID )
            {
            // InternalSparrow.g:5559:4: (otherlv_1= RULE_ID )
            // InternalSparrow.g:5560:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSubjectExpressRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_79); 

            					newLeafNode(otherlv_1, grammarAccess.getSubjectExpressAccess().getSubjectInitExpressionsCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,101,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getSubjectExpressAccess().getFullStopKeyword_2());
            		
            // InternalSparrow.g:5575:3: ( (lv_attribute_3_0= RULE_ID ) )
            // InternalSparrow.g:5576:4: (lv_attribute_3_0= RULE_ID )
            {
            // InternalSparrow.g:5576:4: (lv_attribute_3_0= RULE_ID )
            // InternalSparrow.g:5577:5: lv_attribute_3_0= RULE_ID
            {
            lv_attribute_3_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_attribute_3_0, grammarAccess.getSubjectExpressAccess().getAttributeIDTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSubjectExpressRule());
            					}
            					setWithLastConsumed(
            						current,
            						"attribute",
            						lv_attribute_3_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleSubjectExpress"


    // $ANTLR start "entryRuleObjectExpress"
    // InternalSparrow.g:5597:1: entryRuleObjectExpress returns [EObject current=null] : iv_ruleObjectExpress= ruleObjectExpress EOF ;
    public final EObject entryRuleObjectExpress() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleObjectExpress = null;


        try {
            // InternalSparrow.g:5597:54: (iv_ruleObjectExpress= ruleObjectExpress EOF )
            // InternalSparrow.g:5598:2: iv_ruleObjectExpress= ruleObjectExpress EOF
            {
             newCompositeNode(grammarAccess.getObjectExpressRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleObjectExpress=ruleObjectExpress();

            state._fsp--;

             current =iv_ruleObjectExpress; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleObjectExpress"


    // $ANTLR start "ruleObjectExpress"
    // InternalSparrow.g:5604:1: ruleObjectExpress returns [EObject current=null] : (otherlv_0= 'o' ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (lv_attribute_3_0= RULE_ID ) ) ) ;
    public final EObject ruleObjectExpress() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_attribute_3_0=null;


        	enterRule();

        try {
            // InternalSparrow.g:5610:2: ( (otherlv_0= 'o' ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (lv_attribute_3_0= RULE_ID ) ) ) )
            // InternalSparrow.g:5611:2: (otherlv_0= 'o' ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (lv_attribute_3_0= RULE_ID ) ) )
            {
            // InternalSparrow.g:5611:2: (otherlv_0= 'o' ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (lv_attribute_3_0= RULE_ID ) ) )
            // InternalSparrow.g:5612:3: otherlv_0= 'o' ( (otherlv_1= RULE_ID ) ) otherlv_2= '.' ( (lv_attribute_3_0= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,102,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getObjectExpressAccess().getOKeyword_0());
            		
            // InternalSparrow.g:5616:3: ( (otherlv_1= RULE_ID ) )
            // InternalSparrow.g:5617:4: (otherlv_1= RULE_ID )
            {
            // InternalSparrow.g:5617:4: (otherlv_1= RULE_ID )
            // InternalSparrow.g:5618:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getObjectExpressRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_79); 

            					newLeafNode(otherlv_1, grammarAccess.getObjectExpressAccess().getObjectInitExpressionoCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,101,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getObjectExpressAccess().getFullStopKeyword_2());
            		
            // InternalSparrow.g:5633:3: ( (lv_attribute_3_0= RULE_ID ) )
            // InternalSparrow.g:5634:4: (lv_attribute_3_0= RULE_ID )
            {
            // InternalSparrow.g:5634:4: (lv_attribute_3_0= RULE_ID )
            // InternalSparrow.g:5635:5: lv_attribute_3_0= RULE_ID
            {
            lv_attribute_3_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_attribute_3_0, grammarAccess.getObjectExpressAccess().getAttributeIDTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getObjectExpressRule());
            					}
            					setWithLastConsumed(
            						current,
            						"attribute",
            						lv_attribute_3_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleObjectExpress"


    // $ANTLR start "entryRuletrueOperation"
    // InternalSparrow.g:5655:1: entryRuletrueOperation returns [EObject current=null] : iv_ruletrueOperation= ruletrueOperation EOF ;
    public final EObject entryRuletrueOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruletrueOperation = null;


        try {
            // InternalSparrow.g:5655:54: (iv_ruletrueOperation= ruletrueOperation EOF )
            // InternalSparrow.g:5656:2: iv_ruletrueOperation= ruletrueOperation EOF
            {
             newCompositeNode(grammarAccess.getTrueOperationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruletrueOperation=ruletrueOperation();

            state._fsp--;

             current =iv_ruletrueOperation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuletrueOperation"


    // $ANTLR start "ruletrueOperation"
    // InternalSparrow.g:5662:1: ruletrueOperation returns [EObject current=null] : (this_transferExpression_0= ruletransferExpression | this_changeExpression_1= rulechangeExpression ) ;
    public final EObject ruletrueOperation() throws RecognitionException {
        EObject current = null;

        EObject this_transferExpression_0 = null;

        EObject this_changeExpression_1 = null;



        	enterRule();

        try {
            // InternalSparrow.g:5668:2: ( (this_transferExpression_0= ruletransferExpression | this_changeExpression_1= rulechangeExpression ) )
            // InternalSparrow.g:5669:2: (this_transferExpression_0= ruletransferExpression | this_changeExpression_1= rulechangeExpression )
            {
            // InternalSparrow.g:5669:2: (this_transferExpression_0= ruletransferExpression | this_changeExpression_1= rulechangeExpression )
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==105) ) {
                alt89=1;
            }
            else if ( ((LA89_0>=106 && LA89_0<=107)||LA89_0==114) ) {
                alt89=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 89, 0, input);

                throw nvae;
            }
            switch (alt89) {
                case 1 :
                    // InternalSparrow.g:5670:3: this_transferExpression_0= ruletransferExpression
                    {

                    			newCompositeNode(grammarAccess.getTrueOperationAccess().getTransferExpressionParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_transferExpression_0=ruletransferExpression();

                    state._fsp--;


                    			current = this_transferExpression_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalSparrow.g:5679:3: this_changeExpression_1= rulechangeExpression
                    {

                    			newCompositeNode(grammarAccess.getTrueOperationAccess().getChangeExpressionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_changeExpression_1=rulechangeExpression();

                    state._fsp--;


                    			current = this_changeExpression_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruletrueOperation"


    // $ANTLR start "entryRulemessageExpression"
    // InternalSparrow.g:5691:1: entryRulemessageExpression returns [EObject current=null] : iv_rulemessageExpression= rulemessageExpression EOF ;
    public final EObject entryRulemessageExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulemessageExpression = null;


        try {
            // InternalSparrow.g:5691:58: (iv_rulemessageExpression= rulemessageExpression EOF )
            // InternalSparrow.g:5692:2: iv_rulemessageExpression= rulemessageExpression EOF
            {
             newCompositeNode(grammarAccess.getMessageExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_rulemessageExpression=rulemessageExpression();

            state._fsp--;

             current =iv_rulemessageExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulemessageExpression"


    // $ANTLR start "rulemessageExpression"
    // InternalSparrow.g:5698:1: rulemessageExpression returns [EObject current=null] : (otherlv_0= 'SetMessage(' ( (lv_everymassage_1_0= ruleeveryMessage ) ) (otherlv_2= ',' ( (lv_everymassage_3_0= ruleeveryMessage ) ) )* otherlv_4= ')' ) ;
    public final EObject rulemessageExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_everymassage_1_0 = null;

        EObject lv_everymassage_3_0 = null;



        	enterRule();

        try {
            // InternalSparrow.g:5704:2: ( (otherlv_0= 'SetMessage(' ( (lv_everymassage_1_0= ruleeveryMessage ) ) (otherlv_2= ',' ( (lv_everymassage_3_0= ruleeveryMessage ) ) )* otherlv_4= ')' ) )
            // InternalSparrow.g:5705:2: (otherlv_0= 'SetMessage(' ( (lv_everymassage_1_0= ruleeveryMessage ) ) (otherlv_2= ',' ( (lv_everymassage_3_0= ruleeveryMessage ) ) )* otherlv_4= ')' )
            {
            // InternalSparrow.g:5705:2: (otherlv_0= 'SetMessage(' ( (lv_everymassage_1_0= ruleeveryMessage ) ) (otherlv_2= ',' ( (lv_everymassage_3_0= ruleeveryMessage ) ) )* otherlv_4= ')' )
            // InternalSparrow.g:5706:3: otherlv_0= 'SetMessage(' ( (lv_everymassage_1_0= ruleeveryMessage ) ) (otherlv_2= ',' ( (lv_everymassage_3_0= ruleeveryMessage ) ) )* otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,103,FOLLOW_80); 

            			newLeafNode(otherlv_0, grammarAccess.getMessageExpressionAccess().getSetMessageKeyword_0());
            		
            // InternalSparrow.g:5710:3: ( (lv_everymassage_1_0= ruleeveryMessage ) )
            // InternalSparrow.g:5711:4: (lv_everymassage_1_0= ruleeveryMessage )
            {
            // InternalSparrow.g:5711:4: (lv_everymassage_1_0= ruleeveryMessage )
            // InternalSparrow.g:5712:5: lv_everymassage_1_0= ruleeveryMessage
            {

            					newCompositeNode(grammarAccess.getMessageExpressionAccess().getEverymassageEveryMessageParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_24);
            lv_everymassage_1_0=ruleeveryMessage();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMessageExpressionRule());
            					}
            					add(
            						current,
            						"everymassage",
            						lv_everymassage_1_0,
            						"org.xtext.example.mydsl.Sparrow.everyMessage");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSparrow.g:5729:3: (otherlv_2= ',' ( (lv_everymassage_3_0= ruleeveryMessage ) ) )*
            loop90:
            do {
                int alt90=2;
                int LA90_0 = input.LA(1);

                if ( (LA90_0==22) ) {
                    alt90=1;
                }


                switch (alt90) {
            	case 1 :
            	    // InternalSparrow.g:5730:4: otherlv_2= ',' ( (lv_everymassage_3_0= ruleeveryMessage ) )
            	    {
            	    otherlv_2=(Token)match(input,22,FOLLOW_80); 

            	    				newLeafNode(otherlv_2, grammarAccess.getMessageExpressionAccess().getCommaKeyword_2_0());
            	    			
            	    // InternalSparrow.g:5734:4: ( (lv_everymassage_3_0= ruleeveryMessage ) )
            	    // InternalSparrow.g:5735:5: (lv_everymassage_3_0= ruleeveryMessage )
            	    {
            	    // InternalSparrow.g:5735:5: (lv_everymassage_3_0= ruleeveryMessage )
            	    // InternalSparrow.g:5736:6: lv_everymassage_3_0= ruleeveryMessage
            	    {

            	    						newCompositeNode(grammarAccess.getMessageExpressionAccess().getEverymassageEveryMessageParserRuleCall_2_1_0());
            	    					
            	    pushFollow(FOLLOW_24);
            	    lv_everymassage_3_0=ruleeveryMessage();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getMessageExpressionRule());
            	    						}
            	    						add(
            	    							current,
            	    							"everymassage",
            	    							lv_everymassage_3_0,
            	    							"org.xtext.example.mydsl.Sparrow.everyMessage");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop90;
                }
            } while (true);

            otherlv_4=(Token)match(input,39,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getMessageExpressionAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulemessageExpression"


    // $ANTLR start "entryRuleeveryMessage"
    // InternalSparrow.g:5762:1: entryRuleeveryMessage returns [EObject current=null] : iv_ruleeveryMessage= ruleeveryMessage EOF ;
    public final EObject entryRuleeveryMessage() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleeveryMessage = null;


        try {
            // InternalSparrow.g:5762:53: (iv_ruleeveryMessage= ruleeveryMessage EOF )
            // InternalSparrow.g:5763:2: iv_ruleeveryMessage= ruleeveryMessage EOF
            {
             newCompositeNode(grammarAccess.getEveryMessageRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleeveryMessage=ruleeveryMessage();

            state._fsp--;

             current =iv_ruleeveryMessage; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleeveryMessage"


    // $ANTLR start "ruleeveryMessage"
    // InternalSparrow.g:5769:1: ruleeveryMessage returns [EObject current=null] : ( ( (lv_symbol_0_0= 'new' ) )? ( (lv_type_1_0= ruletype ) ) ( (lv_message_2_0= RULE_ID ) ) ) ;
    public final EObject ruleeveryMessage() throws RecognitionException {
        EObject current = null;

        Token lv_symbol_0_0=null;
        Token lv_message_2_0=null;
        AntlrDatatypeRuleToken lv_type_1_0 = null;



        	enterRule();

        try {
            // InternalSparrow.g:5775:2: ( ( ( (lv_symbol_0_0= 'new' ) )? ( (lv_type_1_0= ruletype ) ) ( (lv_message_2_0= RULE_ID ) ) ) )
            // InternalSparrow.g:5776:2: ( ( (lv_symbol_0_0= 'new' ) )? ( (lv_type_1_0= ruletype ) ) ( (lv_message_2_0= RULE_ID ) ) )
            {
            // InternalSparrow.g:5776:2: ( ( (lv_symbol_0_0= 'new' ) )? ( (lv_type_1_0= ruletype ) ) ( (lv_message_2_0= RULE_ID ) ) )
            // InternalSparrow.g:5777:3: ( (lv_symbol_0_0= 'new' ) )? ( (lv_type_1_0= ruletype ) ) ( (lv_message_2_0= RULE_ID ) )
            {
            // InternalSparrow.g:5777:3: ( (lv_symbol_0_0= 'new' ) )?
            int alt91=2;
            int LA91_0 = input.LA(1);

            if ( (LA91_0==104) ) {
                alt91=1;
            }
            switch (alt91) {
                case 1 :
                    // InternalSparrow.g:5778:4: (lv_symbol_0_0= 'new' )
                    {
                    // InternalSparrow.g:5778:4: (lv_symbol_0_0= 'new' )
                    // InternalSparrow.g:5779:5: lv_symbol_0_0= 'new'
                    {
                    lv_symbol_0_0=(Token)match(input,104,FOLLOW_27); 

                    					newLeafNode(lv_symbol_0_0, grammarAccess.getEveryMessageAccess().getSymbolNewKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getEveryMessageRule());
                    					}
                    					setWithLastConsumed(current, "symbol", lv_symbol_0_0, "new");
                    				

                    }


                    }
                    break;

            }

            // InternalSparrow.g:5791:3: ( (lv_type_1_0= ruletype ) )
            // InternalSparrow.g:5792:4: (lv_type_1_0= ruletype )
            {
            // InternalSparrow.g:5792:4: (lv_type_1_0= ruletype )
            // InternalSparrow.g:5793:5: lv_type_1_0= ruletype
            {

            					newCompositeNode(grammarAccess.getEveryMessageAccess().getTypeTypeParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_3);
            lv_type_1_0=ruletype();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEveryMessageRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_1_0,
            						"org.xtext.example.mydsl.Sparrow.type");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalSparrow.g:5810:3: ( (lv_message_2_0= RULE_ID ) )
            // InternalSparrow.g:5811:4: (lv_message_2_0= RULE_ID )
            {
            // InternalSparrow.g:5811:4: (lv_message_2_0= RULE_ID )
            // InternalSparrow.g:5812:5: lv_message_2_0= RULE_ID
            {
            lv_message_2_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            					newLeafNode(lv_message_2_0, grammarAccess.getEveryMessageAccess().getMessageIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEveryMessageRule());
            					}
            					setWithLastConsumed(
            						current,
            						"message",
            						lv_message_2_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleeveryMessage"


    // $ANTLR start "entryRuletransferExpression"
    // InternalSparrow.g:5832:1: entryRuletransferExpression returns [EObject current=null] : iv_ruletransferExpression= ruletransferExpression EOF ;
    public final EObject entryRuletransferExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruletransferExpression = null;


        try {
            // InternalSparrow.g:5832:59: (iv_ruletransferExpression= ruletransferExpression EOF )
            // InternalSparrow.g:5833:2: iv_ruletransferExpression= ruletransferExpression EOF
            {
             newCompositeNode(grammarAccess.getTransferExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruletransferExpression=ruletransferExpression();

            state._fsp--;

             current =iv_ruletransferExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuletransferExpression"


    // $ANTLR start "ruletransferExpression"
    // InternalSparrow.g:5839:1: ruletransferExpression returns [EObject current=null] : (otherlv_0= 'transfer(' ( (otherlv_1= RULE_ID ) ) otherlv_2= ',' ( (lv_value_3_0= ruleMixExpression ) ) otherlv_4= ')' ) ;
    public final EObject ruletransferExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalSparrow.g:5845:2: ( (otherlv_0= 'transfer(' ( (otherlv_1= RULE_ID ) ) otherlv_2= ',' ( (lv_value_3_0= ruleMixExpression ) ) otherlv_4= ')' ) )
            // InternalSparrow.g:5846:2: (otherlv_0= 'transfer(' ( (otherlv_1= RULE_ID ) ) otherlv_2= ',' ( (lv_value_3_0= ruleMixExpression ) ) otherlv_4= ')' )
            {
            // InternalSparrow.g:5846:2: (otherlv_0= 'transfer(' ( (otherlv_1= RULE_ID ) ) otherlv_2= ',' ( (lv_value_3_0= ruleMixExpression ) ) otherlv_4= ')' )
            // InternalSparrow.g:5847:3: otherlv_0= 'transfer(' ( (otherlv_1= RULE_ID ) ) otherlv_2= ',' ( (lv_value_3_0= ruleMixExpression ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,105,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getTransferExpressionAccess().getTransferKeyword_0());
            		
            // InternalSparrow.g:5851:3: ( (otherlv_1= RULE_ID ) )
            // InternalSparrow.g:5852:4: (otherlv_1= RULE_ID )
            {
            // InternalSparrow.g:5852:4: (otherlv_1= RULE_ID )
            // InternalSparrow.g:5853:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getTransferExpressionRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_32); 

            					newLeafNode(otherlv_1, grammarAccess.getTransferExpressionAccess().getPersonInitExpressionsCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,22,FOLLOW_70); 

            			newLeafNode(otherlv_2, grammarAccess.getTransferExpressionAccess().getCommaKeyword_2());
            		
            // InternalSparrow.g:5868:3: ( (lv_value_3_0= ruleMixExpression ) )
            // InternalSparrow.g:5869:4: (lv_value_3_0= ruleMixExpression )
            {
            // InternalSparrow.g:5869:4: (lv_value_3_0= ruleMixExpression )
            // InternalSparrow.g:5870:5: lv_value_3_0= ruleMixExpression
            {

            					newCompositeNode(grammarAccess.getTransferExpressionAccess().getValueMixExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_64);
            lv_value_3_0=ruleMixExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getTransferExpressionRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_3_0,
            						"org.xtext.example.mydsl.Sparrow.MixExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,39,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getTransferExpressionAccess().getRightParenthesisKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruletransferExpression"


    // $ANTLR start "entryRulechangeExpression"
    // InternalSparrow.g:5895:1: entryRulechangeExpression returns [EObject current=null] : iv_rulechangeExpression= rulechangeExpression EOF ;
    public final EObject entryRulechangeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_rulechangeExpression = null;


        try {
            // InternalSparrow.g:5895:57: (iv_rulechangeExpression= rulechangeExpression EOF )
            // InternalSparrow.g:5896:2: iv_rulechangeExpression= rulechangeExpression EOF
            {
             newCompositeNode(grammarAccess.getChangeExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_rulechangeExpression=rulechangeExpression();

            state._fsp--;

             current =iv_rulechangeExpression; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulechangeExpression"


    // $ANTLR start "rulechangeExpression"
    // InternalSparrow.g:5902:1: rulechangeExpression returns [EObject current=null] : (this_changeContract_0= rulechangeContract | this_changeRule_1= rulechangeRule | this_otherchange_2= ruleotherchange | this_changeString_3= rulechangeString | this_changeOther_4= rulechangeOther | this_changeAddress_5= rulechangeAddress ) ;
    public final EObject rulechangeExpression() throws RecognitionException {
        EObject current = null;

        EObject this_changeContract_0 = null;

        EObject this_changeRule_1 = null;

        EObject this_otherchange_2 = null;

        EObject this_changeString_3 = null;

        EObject this_changeOther_4 = null;

        EObject this_changeAddress_5 = null;



        	enterRule();

        try {
            // InternalSparrow.g:5908:2: ( (this_changeContract_0= rulechangeContract | this_changeRule_1= rulechangeRule | this_otherchange_2= ruleotherchange | this_changeString_3= rulechangeString | this_changeOther_4= rulechangeOther | this_changeAddress_5= rulechangeAddress ) )
            // InternalSparrow.g:5909:2: (this_changeContract_0= rulechangeContract | this_changeRule_1= rulechangeRule | this_otherchange_2= ruleotherchange | this_changeString_3= rulechangeString | this_changeOther_4= rulechangeOther | this_changeAddress_5= rulechangeAddress )
            {
            // InternalSparrow.g:5909:2: (this_changeContract_0= rulechangeContract | this_changeRule_1= rulechangeRule | this_otherchange_2= ruleotherchange | this_changeString_3= rulechangeString | this_changeOther_4= rulechangeOther | this_changeAddress_5= rulechangeAddress )
            int alt92=6;
            alt92 = dfa92.predict(input);
            switch (alt92) {
                case 1 :
                    // InternalSparrow.g:5910:3: this_changeContract_0= rulechangeContract
                    {

                    			newCompositeNode(grammarAccess.getChangeExpressionAccess().getChangeContractParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_changeContract_0=rulechangeContract();

                    state._fsp--;


                    			current = this_changeContract_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalSparrow.g:5919:3: this_changeRule_1= rulechangeRule
                    {

                    			newCompositeNode(grammarAccess.getChangeExpressionAccess().getChangeRuleParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_changeRule_1=rulechangeRule();

                    state._fsp--;


                    			current = this_changeRule_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalSparrow.g:5928:3: this_otherchange_2= ruleotherchange
                    {

                    			newCompositeNode(grammarAccess.getChangeExpressionAccess().getOtherchangeParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_otherchange_2=ruleotherchange();

                    state._fsp--;


                    			current = this_otherchange_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalSparrow.g:5937:3: this_changeString_3= rulechangeString
                    {

                    			newCompositeNode(grammarAccess.getChangeExpressionAccess().getChangeStringParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_changeString_3=rulechangeString();

                    state._fsp--;


                    			current = this_changeString_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalSparrow.g:5946:3: this_changeOther_4= rulechangeOther
                    {

                    			newCompositeNode(grammarAccess.getChangeExpressionAccess().getChangeOtherParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_changeOther_4=rulechangeOther();

                    state._fsp--;


                    			current = this_changeOther_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalSparrow.g:5955:3: this_changeAddress_5= rulechangeAddress
                    {

                    			newCompositeNode(grammarAccess.getChangeExpressionAccess().getChangeAddressParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_changeAddress_5=rulechangeAddress();

                    state._fsp--;


                    			current = this_changeAddress_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulechangeExpression"


    // $ANTLR start "entryRulechangeString"
    // InternalSparrow.g:5967:1: entryRulechangeString returns [EObject current=null] : iv_rulechangeString= rulechangeString EOF ;
    public final EObject entryRulechangeString() throws RecognitionException {
        EObject current = null;

        EObject iv_rulechangeString = null;


        try {
            // InternalSparrow.g:5967:53: (iv_rulechangeString= rulechangeString EOF )
            // InternalSparrow.g:5968:2: iv_rulechangeString= rulechangeString EOF
            {
             newCompositeNode(grammarAccess.getChangeStringRule()); 
            pushFollow(FOLLOW_1);
            iv_rulechangeString=rulechangeString();

            state._fsp--;

             current =iv_rulechangeString; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulechangeString"


    // $ANTLR start "rulechangeString"
    // InternalSparrow.g:5974:1: rulechangeString returns [EObject current=null] : (otherlv_0= 'assignString(' ( (lv_changeThing_1_0= ruleMixExpression ) ) otherlv_2= ',' ( (lv_changeResult_3_0= ruleMixExpression ) ) otherlv_4= ')' ) ;
    public final EObject rulechangeString() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_changeThing_1_0 = null;

        EObject lv_changeResult_3_0 = null;



        	enterRule();

        try {
            // InternalSparrow.g:5980:2: ( (otherlv_0= 'assignString(' ( (lv_changeThing_1_0= ruleMixExpression ) ) otherlv_2= ',' ( (lv_changeResult_3_0= ruleMixExpression ) ) otherlv_4= ')' ) )
            // InternalSparrow.g:5981:2: (otherlv_0= 'assignString(' ( (lv_changeThing_1_0= ruleMixExpression ) ) otherlv_2= ',' ( (lv_changeResult_3_0= ruleMixExpression ) ) otherlv_4= ')' )
            {
            // InternalSparrow.g:5981:2: (otherlv_0= 'assignString(' ( (lv_changeThing_1_0= ruleMixExpression ) ) otherlv_2= ',' ( (lv_changeResult_3_0= ruleMixExpression ) ) otherlv_4= ')' )
            // InternalSparrow.g:5982:3: otherlv_0= 'assignString(' ( (lv_changeThing_1_0= ruleMixExpression ) ) otherlv_2= ',' ( (lv_changeResult_3_0= ruleMixExpression ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,106,FOLLOW_70); 

            			newLeafNode(otherlv_0, grammarAccess.getChangeStringAccess().getAssignStringKeyword_0());
            		
            // InternalSparrow.g:5986:3: ( (lv_changeThing_1_0= ruleMixExpression ) )
            // InternalSparrow.g:5987:4: (lv_changeThing_1_0= ruleMixExpression )
            {
            // InternalSparrow.g:5987:4: (lv_changeThing_1_0= ruleMixExpression )
            // InternalSparrow.g:5988:5: lv_changeThing_1_0= ruleMixExpression
            {

            					newCompositeNode(grammarAccess.getChangeStringAccess().getChangeThingMixExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_32);
            lv_changeThing_1_0=ruleMixExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getChangeStringRule());
            					}
            					set(
            						current,
            						"changeThing",
            						lv_changeThing_1_0,
            						"org.xtext.example.mydsl.Sparrow.MixExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,22,FOLLOW_70); 

            			newLeafNode(otherlv_2, grammarAccess.getChangeStringAccess().getCommaKeyword_2());
            		
            // InternalSparrow.g:6009:3: ( (lv_changeResult_3_0= ruleMixExpression ) )
            // InternalSparrow.g:6010:4: (lv_changeResult_3_0= ruleMixExpression )
            {
            // InternalSparrow.g:6010:4: (lv_changeResult_3_0= ruleMixExpression )
            // InternalSparrow.g:6011:5: lv_changeResult_3_0= ruleMixExpression
            {

            					newCompositeNode(grammarAccess.getChangeStringAccess().getChangeResultMixExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_64);
            lv_changeResult_3_0=ruleMixExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getChangeStringRule());
            					}
            					set(
            						current,
            						"changeResult",
            						lv_changeResult_3_0,
            						"org.xtext.example.mydsl.Sparrow.MixExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,39,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getChangeStringAccess().getRightParenthesisKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulechangeString"


    // $ANTLR start "entryRuleotherchange"
    // InternalSparrow.g:6036:1: entryRuleotherchange returns [EObject current=null] : iv_ruleotherchange= ruleotherchange EOF ;
    public final EObject entryRuleotherchange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleotherchange = null;


        try {
            // InternalSparrow.g:6036:52: (iv_ruleotherchange= ruleotherchange EOF )
            // InternalSparrow.g:6037:2: iv_ruleotherchange= ruleotherchange EOF
            {
             newCompositeNode(grammarAccess.getOtherchangeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleotherchange=ruleotherchange();

            state._fsp--;

             current =iv_ruleotherchange; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleotherchange"


    // $ANTLR start "ruleotherchange"
    // InternalSparrow.g:6043:1: ruleotherchange returns [EObject current=null] : (otherlv_0= 'assign(' ( (lv_changeThing_1_0= ruleMixExpression ) ) otherlv_2= ',' ( (lv_changeResult_3_0= ruleMixExpression ) ) otherlv_4= ')' ) ;
    public final EObject ruleotherchange() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_changeThing_1_0 = null;

        EObject lv_changeResult_3_0 = null;



        	enterRule();

        try {
            // InternalSparrow.g:6049:2: ( (otherlv_0= 'assign(' ( (lv_changeThing_1_0= ruleMixExpression ) ) otherlv_2= ',' ( (lv_changeResult_3_0= ruleMixExpression ) ) otherlv_4= ')' ) )
            // InternalSparrow.g:6050:2: (otherlv_0= 'assign(' ( (lv_changeThing_1_0= ruleMixExpression ) ) otherlv_2= ',' ( (lv_changeResult_3_0= ruleMixExpression ) ) otherlv_4= ')' )
            {
            // InternalSparrow.g:6050:2: (otherlv_0= 'assign(' ( (lv_changeThing_1_0= ruleMixExpression ) ) otherlv_2= ',' ( (lv_changeResult_3_0= ruleMixExpression ) ) otherlv_4= ')' )
            // InternalSparrow.g:6051:3: otherlv_0= 'assign(' ( (lv_changeThing_1_0= ruleMixExpression ) ) otherlv_2= ',' ( (lv_changeResult_3_0= ruleMixExpression ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,107,FOLLOW_70); 

            			newLeafNode(otherlv_0, grammarAccess.getOtherchangeAccess().getAssignKeyword_0());
            		
            // InternalSparrow.g:6055:3: ( (lv_changeThing_1_0= ruleMixExpression ) )
            // InternalSparrow.g:6056:4: (lv_changeThing_1_0= ruleMixExpression )
            {
            // InternalSparrow.g:6056:4: (lv_changeThing_1_0= ruleMixExpression )
            // InternalSparrow.g:6057:5: lv_changeThing_1_0= ruleMixExpression
            {

            					newCompositeNode(grammarAccess.getOtherchangeAccess().getChangeThingMixExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_32);
            lv_changeThing_1_0=ruleMixExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOtherchangeRule());
            					}
            					set(
            						current,
            						"changeThing",
            						lv_changeThing_1_0,
            						"org.xtext.example.mydsl.Sparrow.MixExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,22,FOLLOW_70); 

            			newLeafNode(otherlv_2, grammarAccess.getOtherchangeAccess().getCommaKeyword_2());
            		
            // InternalSparrow.g:6078:3: ( (lv_changeResult_3_0= ruleMixExpression ) )
            // InternalSparrow.g:6079:4: (lv_changeResult_3_0= ruleMixExpression )
            {
            // InternalSparrow.g:6079:4: (lv_changeResult_3_0= ruleMixExpression )
            // InternalSparrow.g:6080:5: lv_changeResult_3_0= ruleMixExpression
            {

            					newCompositeNode(grammarAccess.getOtherchangeAccess().getChangeResultMixExpressionParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_64);
            lv_changeResult_3_0=ruleMixExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOtherchangeRule());
            					}
            					set(
            						current,
            						"changeResult",
            						lv_changeResult_3_0,
            						"org.xtext.example.mydsl.Sparrow.MixExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,39,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getOtherchangeAccess().getRightParenthesisKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleotherchange"


    // $ANTLR start "entryRulechangeContract"
    // InternalSparrow.g:6105:1: entryRulechangeContract returns [EObject current=null] : iv_rulechangeContract= rulechangeContract EOF ;
    public final EObject entryRulechangeContract() throws RecognitionException {
        EObject current = null;

        EObject iv_rulechangeContract = null;


        try {
            // InternalSparrow.g:6105:55: (iv_rulechangeContract= rulechangeContract EOF )
            // InternalSparrow.g:6106:2: iv_rulechangeContract= rulechangeContract EOF
            {
             newCompositeNode(grammarAccess.getChangeContractRule()); 
            pushFollow(FOLLOW_1);
            iv_rulechangeContract=rulechangeContract();

            state._fsp--;

             current =iv_rulechangeContract; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulechangeContract"


    // $ANTLR start "rulechangeContract"
    // InternalSparrow.g:6112:1: rulechangeContract returns [EObject current=null] : (otherlv_0= 'assign(' otherlv_1= 'ContractState' otherlv_2= ',' ( (lv_changeResult_3_0= ruleContractState ) ) otherlv_4= ')' ) ;
    public final EObject rulechangeContract() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_changeResult_3_0 = null;



        	enterRule();

        try {
            // InternalSparrow.g:6118:2: ( (otherlv_0= 'assign(' otherlv_1= 'ContractState' otherlv_2= ',' ( (lv_changeResult_3_0= ruleContractState ) ) otherlv_4= ')' ) )
            // InternalSparrow.g:6119:2: (otherlv_0= 'assign(' otherlv_1= 'ContractState' otherlv_2= ',' ( (lv_changeResult_3_0= ruleContractState ) ) otherlv_4= ')' )
            {
            // InternalSparrow.g:6119:2: (otherlv_0= 'assign(' otherlv_1= 'ContractState' otherlv_2= ',' ( (lv_changeResult_3_0= ruleContractState ) ) otherlv_4= ')' )
            // InternalSparrow.g:6120:3: otherlv_0= 'assign(' otherlv_1= 'ContractState' otherlv_2= ',' ( (lv_changeResult_3_0= ruleContractState ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,107,FOLLOW_81); 

            			newLeafNode(otherlv_0, grammarAccess.getChangeContractAccess().getAssignKeyword_0());
            		
            otherlv_1=(Token)match(input,108,FOLLOW_32); 

            			newLeafNode(otherlv_1, grammarAccess.getChangeContractAccess().getContractStateKeyword_1());
            		
            otherlv_2=(Token)match(input,22,FOLLOW_82); 

            			newLeafNode(otherlv_2, grammarAccess.getChangeContractAccess().getCommaKeyword_2());
            		
            // InternalSparrow.g:6132:3: ( (lv_changeResult_3_0= ruleContractState ) )
            // InternalSparrow.g:6133:4: (lv_changeResult_3_0= ruleContractState )
            {
            // InternalSparrow.g:6133:4: (lv_changeResult_3_0= ruleContractState )
            // InternalSparrow.g:6134:5: lv_changeResult_3_0= ruleContractState
            {

            					newCompositeNode(grammarAccess.getChangeContractAccess().getChangeResultContractStateParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_64);
            lv_changeResult_3_0=ruleContractState();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getChangeContractRule());
            					}
            					set(
            						current,
            						"changeResult",
            						lv_changeResult_3_0,
            						"org.xtext.example.mydsl.Sparrow.ContractState");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,39,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getChangeContractAccess().getRightParenthesisKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulechangeContract"


    // $ANTLR start "entryRuleContractState"
    // InternalSparrow.g:6159:1: entryRuleContractState returns [String current=null] : iv_ruleContractState= ruleContractState EOF ;
    public final String entryRuleContractState() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleContractState = null;


        try {
            // InternalSparrow.g:6159:53: (iv_ruleContractState= ruleContractState EOF )
            // InternalSparrow.g:6160:2: iv_ruleContractState= ruleContractState EOF
            {
             newCompositeNode(grammarAccess.getContractStateRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContractState=ruleContractState();

            state._fsp--;

             current =iv_ruleContractState.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContractState"


    // $ANTLR start "ruleContractState"
    // InternalSparrow.g:6166:1: ruleContractState returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'start' | kw= 'pause' | kw= 'restart' | kw= 'terminate' | kw= 'finish' ) ;
    public final AntlrDatatypeRuleToken ruleContractState() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSparrow.g:6172:2: ( (kw= 'start' | kw= 'pause' | kw= 'restart' | kw= 'terminate' | kw= 'finish' ) )
            // InternalSparrow.g:6173:2: (kw= 'start' | kw= 'pause' | kw= 'restart' | kw= 'terminate' | kw= 'finish' )
            {
            // InternalSparrow.g:6173:2: (kw= 'start' | kw= 'pause' | kw= 'restart' | kw= 'terminate' | kw= 'finish' )
            int alt93=5;
            switch ( input.LA(1) ) {
            case 109:
                {
                alt93=1;
                }
                break;
            case 110:
                {
                alt93=2;
                }
                break;
            case 111:
                {
                alt93=3;
                }
                break;
            case 112:
                {
                alt93=4;
                }
                break;
            case 113:
                {
                alt93=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 93, 0, input);

                throw nvae;
            }

            switch (alt93) {
                case 1 :
                    // InternalSparrow.g:6174:3: kw= 'start'
                    {
                    kw=(Token)match(input,109,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContractStateAccess().getStartKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalSparrow.g:6180:3: kw= 'pause'
                    {
                    kw=(Token)match(input,110,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContractStateAccess().getPauseKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalSparrow.g:6186:3: kw= 'restart'
                    {
                    kw=(Token)match(input,111,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContractStateAccess().getRestartKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalSparrow.g:6192:3: kw= 'terminate'
                    {
                    kw=(Token)match(input,112,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContractStateAccess().getTerminateKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalSparrow.g:6198:3: kw= 'finish'
                    {
                    kw=(Token)match(input,113,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getContractStateAccess().getFinishKeyword_4());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContractState"


    // $ANTLR start "entryRulechangeRule"
    // InternalSparrow.g:6207:1: entryRulechangeRule returns [EObject current=null] : iv_rulechangeRule= rulechangeRule EOF ;
    public final EObject entryRulechangeRule() throws RecognitionException {
        EObject current = null;

        EObject iv_rulechangeRule = null;


        try {
            // InternalSparrow.g:6207:51: (iv_rulechangeRule= rulechangeRule EOF )
            // InternalSparrow.g:6208:2: iv_rulechangeRule= rulechangeRule EOF
            {
             newCompositeNode(grammarAccess.getChangeRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_rulechangeRule=rulechangeRule();

            state._fsp--;

             current =iv_rulechangeRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulechangeRule"


    // $ANTLR start "rulechangeRule"
    // InternalSparrow.g:6214:1: rulechangeRule returns [EObject current=null] : (otherlv_0= 'assign(' ( (otherlv_1= RULE_ID ) ) otherlv_2= ',' ( (lv_changeResult_3_0= ruleBOOLEAN ) ) otherlv_4= ')' ) ;
    public final EObject rulechangeRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_changeResult_3_0 = null;



        	enterRule();

        try {
            // InternalSparrow.g:6220:2: ( (otherlv_0= 'assign(' ( (otherlv_1= RULE_ID ) ) otherlv_2= ',' ( (lv_changeResult_3_0= ruleBOOLEAN ) ) otherlv_4= ')' ) )
            // InternalSparrow.g:6221:2: (otherlv_0= 'assign(' ( (otherlv_1= RULE_ID ) ) otherlv_2= ',' ( (lv_changeResult_3_0= ruleBOOLEAN ) ) otherlv_4= ')' )
            {
            // InternalSparrow.g:6221:2: (otherlv_0= 'assign(' ( (otherlv_1= RULE_ID ) ) otherlv_2= ',' ( (lv_changeResult_3_0= ruleBOOLEAN ) ) otherlv_4= ')' )
            // InternalSparrow.g:6222:3: otherlv_0= 'assign(' ( (otherlv_1= RULE_ID ) ) otherlv_2= ',' ( (lv_changeResult_3_0= ruleBOOLEAN ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,107,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getChangeRuleAccess().getAssignKeyword_0());
            		
            // InternalSparrow.g:6226:3: ( (otherlv_1= RULE_ID ) )
            // InternalSparrow.g:6227:4: (otherlv_1= RULE_ID )
            {
            // InternalSparrow.g:6227:4: (otherlv_1= RULE_ID )
            // InternalSparrow.g:6228:5: otherlv_1= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getChangeRuleRule());
            					}
            				
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_32); 

            					newLeafNode(otherlv_1, grammarAccess.getChangeRuleAccess().getChangeThingRuleExpressionCrossReference_1_0());
            				

            }


            }

            otherlv_2=(Token)match(input,22,FOLLOW_83); 

            			newLeafNode(otherlv_2, grammarAccess.getChangeRuleAccess().getCommaKeyword_2());
            		
            // InternalSparrow.g:6243:3: ( (lv_changeResult_3_0= ruleBOOLEAN ) )
            // InternalSparrow.g:6244:4: (lv_changeResult_3_0= ruleBOOLEAN )
            {
            // InternalSparrow.g:6244:4: (lv_changeResult_3_0= ruleBOOLEAN )
            // InternalSparrow.g:6245:5: lv_changeResult_3_0= ruleBOOLEAN
            {

            					newCompositeNode(grammarAccess.getChangeRuleAccess().getChangeResultBOOLEANParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_64);
            lv_changeResult_3_0=ruleBOOLEAN();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getChangeRuleRule());
            					}
            					set(
            						current,
            						"changeResult",
            						lv_changeResult_3_0,
            						"org.xtext.example.mydsl.Sparrow.BOOLEAN");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,39,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getChangeRuleAccess().getRightParenthesisKeyword_4());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulechangeRule"


    // $ANTLR start "entryRulechangeOther"
    // InternalSparrow.g:6270:1: entryRulechangeOther returns [EObject current=null] : iv_rulechangeOther= rulechangeOther EOF ;
    public final EObject entryRulechangeOther() throws RecognitionException {
        EObject current = null;

        EObject iv_rulechangeOther = null;


        try {
            // InternalSparrow.g:6270:52: (iv_rulechangeOther= rulechangeOther EOF )
            // InternalSparrow.g:6271:2: iv_rulechangeOther= rulechangeOther EOF
            {
             newCompositeNode(grammarAccess.getChangeOtherRule()); 
            pushFollow(FOLLOW_1);
            iv_rulechangeOther=rulechangeOther();

            state._fsp--;

             current =iv_rulechangeOther; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulechangeOther"


    // $ANTLR start "rulechangeOther"
    // InternalSparrow.g:6277:1: rulechangeOther returns [EObject current=null] : (otherlv_0= 'change(' otherlv_1= 'CM' ( (lv_changeThing_2_0= ruleSingleExpression ) ) otherlv_3= ',' ( (lv_changeResult_4_0= ruleBOOLEAN ) ) otherlv_5= ')' ) ;
    public final EObject rulechangeOther() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_changeThing_2_0 = null;

        AntlrDatatypeRuleToken lv_changeResult_4_0 = null;



        	enterRule();

        try {
            // InternalSparrow.g:6283:2: ( (otherlv_0= 'change(' otherlv_1= 'CM' ( (lv_changeThing_2_0= ruleSingleExpression ) ) otherlv_3= ',' ( (lv_changeResult_4_0= ruleBOOLEAN ) ) otherlv_5= ')' ) )
            // InternalSparrow.g:6284:2: (otherlv_0= 'change(' otherlv_1= 'CM' ( (lv_changeThing_2_0= ruleSingleExpression ) ) otherlv_3= ',' ( (lv_changeResult_4_0= ruleBOOLEAN ) ) otherlv_5= ')' )
            {
            // InternalSparrow.g:6284:2: (otherlv_0= 'change(' otherlv_1= 'CM' ( (lv_changeThing_2_0= ruleSingleExpression ) ) otherlv_3= ',' ( (lv_changeResult_4_0= ruleBOOLEAN ) ) otherlv_5= ')' )
            // InternalSparrow.g:6285:3: otherlv_0= 'change(' otherlv_1= 'CM' ( (lv_changeThing_2_0= ruleSingleExpression ) ) otherlv_3= ',' ( (lv_changeResult_4_0= ruleBOOLEAN ) ) otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,114,FOLLOW_84); 

            			newLeafNode(otherlv_0, grammarAccess.getChangeOtherAccess().getChangeKeyword_0());
            		
            otherlv_1=(Token)match(input,115,FOLLOW_70); 

            			newLeafNode(otherlv_1, grammarAccess.getChangeOtherAccess().getCMKeyword_1());
            		
            // InternalSparrow.g:6293:3: ( (lv_changeThing_2_0= ruleSingleExpression ) )
            // InternalSparrow.g:6294:4: (lv_changeThing_2_0= ruleSingleExpression )
            {
            // InternalSparrow.g:6294:4: (lv_changeThing_2_0= ruleSingleExpression )
            // InternalSparrow.g:6295:5: lv_changeThing_2_0= ruleSingleExpression
            {

            					newCompositeNode(grammarAccess.getChangeOtherAccess().getChangeThingSingleExpressionParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_32);
            lv_changeThing_2_0=ruleSingleExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getChangeOtherRule());
            					}
            					set(
            						current,
            						"changeThing",
            						lv_changeThing_2_0,
            						"org.xtext.example.mydsl.Sparrow.SingleExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,22,FOLLOW_83); 

            			newLeafNode(otherlv_3, grammarAccess.getChangeOtherAccess().getCommaKeyword_3());
            		
            // InternalSparrow.g:6316:3: ( (lv_changeResult_4_0= ruleBOOLEAN ) )
            // InternalSparrow.g:6317:4: (lv_changeResult_4_0= ruleBOOLEAN )
            {
            // InternalSparrow.g:6317:4: (lv_changeResult_4_0= ruleBOOLEAN )
            // InternalSparrow.g:6318:5: lv_changeResult_4_0= ruleBOOLEAN
            {

            					newCompositeNode(grammarAccess.getChangeOtherAccess().getChangeResultBOOLEANParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_64);
            lv_changeResult_4_0=ruleBOOLEAN();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getChangeOtherRule());
            					}
            					set(
            						current,
            						"changeResult",
            						lv_changeResult_4_0,
            						"org.xtext.example.mydsl.Sparrow.BOOLEAN");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,39,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getChangeOtherAccess().getRightParenthesisKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulechangeOther"


    // $ANTLR start "entryRulechangeAddress"
    // InternalSparrow.g:6343:1: entryRulechangeAddress returns [EObject current=null] : iv_rulechangeAddress= rulechangeAddress EOF ;
    public final EObject entryRulechangeAddress() throws RecognitionException {
        EObject current = null;

        EObject iv_rulechangeAddress = null;


        try {
            // InternalSparrow.g:6343:54: (iv_rulechangeAddress= rulechangeAddress EOF )
            // InternalSparrow.g:6344:2: iv_rulechangeAddress= rulechangeAddress EOF
            {
             newCompositeNode(grammarAccess.getChangeAddressRule()); 
            pushFollow(FOLLOW_1);
            iv_rulechangeAddress=rulechangeAddress();

            state._fsp--;

             current =iv_rulechangeAddress; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulechangeAddress"


    // $ANTLR start "rulechangeAddress"
    // InternalSparrow.g:6350:1: rulechangeAddress returns [EObject current=null] : (otherlv_0= 'assign(' ( (lv_changeThing_1_0= ruleMixExpression ) ) otherlv_2= ',' otherlv_3= 'a' ( (lv_changeResult_4_0= ruleMixExpression ) ) otherlv_5= ')' ) ;
    public final EObject rulechangeAddress() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_changeThing_1_0 = null;

        EObject lv_changeResult_4_0 = null;



        	enterRule();

        try {
            // InternalSparrow.g:6356:2: ( (otherlv_0= 'assign(' ( (lv_changeThing_1_0= ruleMixExpression ) ) otherlv_2= ',' otherlv_3= 'a' ( (lv_changeResult_4_0= ruleMixExpression ) ) otherlv_5= ')' ) )
            // InternalSparrow.g:6357:2: (otherlv_0= 'assign(' ( (lv_changeThing_1_0= ruleMixExpression ) ) otherlv_2= ',' otherlv_3= 'a' ( (lv_changeResult_4_0= ruleMixExpression ) ) otherlv_5= ')' )
            {
            // InternalSparrow.g:6357:2: (otherlv_0= 'assign(' ( (lv_changeThing_1_0= ruleMixExpression ) ) otherlv_2= ',' otherlv_3= 'a' ( (lv_changeResult_4_0= ruleMixExpression ) ) otherlv_5= ')' )
            // InternalSparrow.g:6358:3: otherlv_0= 'assign(' ( (lv_changeThing_1_0= ruleMixExpression ) ) otherlv_2= ',' otherlv_3= 'a' ( (lv_changeResult_4_0= ruleMixExpression ) ) otherlv_5= ')'
            {
            otherlv_0=(Token)match(input,107,FOLLOW_70); 

            			newLeafNode(otherlv_0, grammarAccess.getChangeAddressAccess().getAssignKeyword_0());
            		
            // InternalSparrow.g:6362:3: ( (lv_changeThing_1_0= ruleMixExpression ) )
            // InternalSparrow.g:6363:4: (lv_changeThing_1_0= ruleMixExpression )
            {
            // InternalSparrow.g:6363:4: (lv_changeThing_1_0= ruleMixExpression )
            // InternalSparrow.g:6364:5: lv_changeThing_1_0= ruleMixExpression
            {

            					newCompositeNode(grammarAccess.getChangeAddressAccess().getChangeThingMixExpressionParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_32);
            lv_changeThing_1_0=ruleMixExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getChangeAddressRule());
            					}
            					set(
            						current,
            						"changeThing",
            						lv_changeThing_1_0,
            						"org.xtext.example.mydsl.Sparrow.MixExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,22,FOLLOW_85); 

            			newLeafNode(otherlv_2, grammarAccess.getChangeAddressAccess().getCommaKeyword_2());
            		
            otherlv_3=(Token)match(input,63,FOLLOW_70); 

            			newLeafNode(otherlv_3, grammarAccess.getChangeAddressAccess().getAKeyword_3());
            		
            // InternalSparrow.g:6389:3: ( (lv_changeResult_4_0= ruleMixExpression ) )
            // InternalSparrow.g:6390:4: (lv_changeResult_4_0= ruleMixExpression )
            {
            // InternalSparrow.g:6390:4: (lv_changeResult_4_0= ruleMixExpression )
            // InternalSparrow.g:6391:5: lv_changeResult_4_0= ruleMixExpression
            {

            					newCompositeNode(grammarAccess.getChangeAddressAccess().getChangeResultMixExpressionParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_64);
            lv_changeResult_4_0=ruleMixExpression();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getChangeAddressRule());
            					}
            					set(
            						current,
            						"changeResult",
            						lv_changeResult_4_0,
            						"org.xtext.example.mydsl.Sparrow.MixExpression");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_5=(Token)match(input,39,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getChangeAddressAccess().getRightParenthesisKeyword_5());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulechangeAddress"


    // $ANTLR start "entryRuleBOOLEAN"
    // InternalSparrow.g:6416:1: entryRuleBOOLEAN returns [String current=null] : iv_ruleBOOLEAN= ruleBOOLEAN EOF ;
    public final String entryRuleBOOLEAN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleBOOLEAN = null;


        try {
            // InternalSparrow.g:6416:47: (iv_ruleBOOLEAN= ruleBOOLEAN EOF )
            // InternalSparrow.g:6417:2: iv_ruleBOOLEAN= ruleBOOLEAN EOF
            {
             newCompositeNode(grammarAccess.getBOOLEANRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBOOLEAN=ruleBOOLEAN();

            state._fsp--;

             current =iv_ruleBOOLEAN.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBOOLEAN"


    // $ANTLR start "ruleBOOLEAN"
    // InternalSparrow.g:6423:1: ruleBOOLEAN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'true' | kw= 'false' ) ;
    public final AntlrDatatypeRuleToken ruleBOOLEAN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalSparrow.g:6429:2: ( (kw= 'true' | kw= 'false' ) )
            // InternalSparrow.g:6430:2: (kw= 'true' | kw= 'false' )
            {
            // InternalSparrow.g:6430:2: (kw= 'true' | kw= 'false' )
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==116) ) {
                alt94=1;
            }
            else if ( (LA94_0==117) ) {
                alt94=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 94, 0, input);

                throw nvae;
            }
            switch (alt94) {
                case 1 :
                    // InternalSparrow.g:6431:3: kw= 'true'
                    {
                    kw=(Token)match(input,116,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getBOOLEANAccess().getTrueKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalSparrow.g:6437:3: kw= 'false'
                    {
                    kw=(Token)match(input,117,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getBOOLEANAccess().getFalseKeyword_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBOOLEAN"

    // Delegated rules


    protected DFA28 dfa28 = new DFA28(this);
    protected DFA85 dfa85 = new DFA85(this);
    protected DFA86 dfa86 = new DFA86(this);
    protected DFA92 dfa92 = new DFA92(this);
    static final String dfa_1s = "\14\uffff";
    static final String dfa_2s = "\1\uffff\1\11\12\uffff";
    static final String dfa_3s = "\1\4\1\23\12\uffff";
    static final String dfa_4s = "\1\165\1\100\12\uffff";
    static final String dfa_5s = "\2\uffff\1\2\1\4\1\5\1\6\1\7\1\10\1\12\1\1\1\11\1\3";
    static final String dfa_6s = "\14\uffff}>";
    static final String[] dfa_7s = {
            "\1\2\1\1\1\7\1\5\1\4\65\uffff\1\10\1\6\64\uffff\2\3",
            "\1\11\2\uffff\1\11\20\uffff\1\11\21\uffff\5\12\2\uffff\1\13",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA28 extends DFA {

        public DFA28(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 28;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "1403:2: (this_AllNumber_0= ruleAllNumber | this_Right_1= ruleRight | this_ThisDate_2= ruleThisDate | this_ThisBoolean_3= ruleThisBoolean | this_url_4= ruleurl | this_ThisDecimal_5= ruleThisDecimal | this_Address_6= ruleAddress | this_ThisString_7= ruleThisString | this_Duration_8= ruleDuration | this_Now_9= ruleNow )";
        }
    }
    static final String dfa_8s = "\12\uffff";
    static final String dfa_9s = "\1\1\2\uffff\1\11\6\uffff";
    static final String dfa_10s = "\1\12\1\uffff\1\4\1\12\6\uffff";
    static final String dfa_11s = "\1\132\1\uffff\1\165\1\132\6\uffff";
    static final String dfa_12s = "\1\uffff\1\2\2\uffff\6\1";
    static final String dfa_13s = "\12\uffff}>";
    static final String[] dfa_14s = {
            "\1\2\13\uffff\1\1\20\uffff\1\1\62\uffff\1\1",
            "",
            "\1\4\1\3\1\uffff\1\4\66\uffff\1\4\41\uffff\5\4\1\uffff\1\4\15\uffff\2\4",
            "\1\11\13\uffff\1\11\20\uffff\1\11\21\uffff\1\5\1\6\1\7\1\10\1\11\2\uffff\1\11\31\uffff\1\11",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final short[] dfa_9 = DFA.unpackEncodedString(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final char[] dfa_11 = DFA.unpackEncodedStringToUnsignedChars(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final short[][] dfa_14 = unpackEncodedStringArray(dfa_14s);

    class DFA85 extends DFA {

        public DFA85(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 85;
            this.eot = dfa_8;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "()* loopback of 4953:3: ( (lv_otherMixExpression_1_0= ruleOtherMixExpression ) )*";
        }
    }
    static final String dfa_15s = "\1\uffff\1\2\2\uffff\1\12\7\uffff";
    static final String dfa_16s = "\1\4\1\12\2\uffff\1\12\7\uffff";
    static final String dfa_17s = "\1\165\1\132\2\uffff\1\132\7\uffff";
    static final String dfa_18s = "\2\uffff\1\1\1\2\1\uffff\1\4\1\5\1\6\1\7\1\10\1\3\1\11";
    static final String[] dfa_19s = {
            "\1\4\1\1\1\uffff\1\2\66\uffff\1\2\41\uffff\1\6\1\10\1\7\1\5\1\3\1\uffff\1\3\15\uffff\2\2",
            "\1\2\13\uffff\1\2\20\uffff\1\2\21\uffff\5\11\2\uffff\1\2\31\uffff\1\2",
            "",
            "",
            "\1\12\13\uffff\1\12\20\uffff\1\12\21\uffff\5\13\34\uffff\1\12",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };
    static final short[] dfa_15 = DFA.unpackEncodedString(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final char[] dfa_17 = DFA.unpackEncodedStringToUnsignedChars(dfa_17s);
    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[][] dfa_19 = unpackEncodedStringArray(dfa_19s);

    class DFA86 extends DFA {

        public DFA86(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 86;
            this.eot = dfa_1;
            this.eof = dfa_15;
            this.min = dfa_16;
            this.max = dfa_17;
            this.accept = dfa_18;
            this.special = dfa_6;
            this.transition = dfa_19;
        }
        public String getDescription() {
            return "5046:2: (this_RegularExpression_0= ruleRegularExpression | this_ThingExpression_1= ruleThingExpression | this_OtherExpression_2= ruleOtherExpression | this_PersonExpression_3= rulePersonExpression | this_RuleTimeExpression_4= ruleRuleTimeExpression | this_FloatExpression_5= ruleFloatExpression | this_StringExpression_6= ruleStringExpression | this_PeriodExpression_7= rulePeriodExpression | this_GetPeriodExpression_8= ruleGetPeriodExpression )";
        }
    }
    static final String dfa_20s = "\141\uffff";
    static final String dfa_21s = "\1\152\1\4\3\uffff\6\12\6\4\5\12\2\4\5\12\1\4\1\5\2\145\1\12\1\47\1\12\1\141\5\12\2\4\1\12\4\4\2\12\2\uffff\1\100\2\4\2\12\1\5\5\12\2\145\6\12\1\47\1\12\1\141\1\uffff\1\5\2\12\1\100\2\4\2\12\1\26\1\5\2\12\1\5\1\26\1\25\2\5\1\25\1\12\1\5\1\12";
    static final String dfa_22s = "\1\162\1\165\3\uffff\1\75\1\100\4\26\6\4\5\26\2\165\5\26\1\165\1\5\2\145\1\26\1\47\1\26\1\141\1\100\4\26\2\4\1\75\4\4\2\47\2\uffff\1\100\2\4\2\26\1\5\5\26\2\145\6\26\1\47\1\26\1\141\1\uffff\1\5\2\26\1\100\2\4\3\26\1\5\2\26\1\5\1\26\1\25\2\5\1\25\1\26\1\5\1\26";
    static final String dfa_23s = "\2\uffff\1\4\1\5\1\1\56\uffff\1\6\1\3\26\uffff\1\2\25\uffff";
    static final String dfa_24s = "\141\uffff}>";
    static final String[] dfa_25s = {
            "\1\2\1\1\6\uffff\1\3",
            "\1\5\1\6\1\uffff\1\7\66\uffff\1\12\41\uffff\1\16\1\20\1\17\1\15\1\14\1\uffff\1\13\5\uffff\1\4\7\uffff\1\10\1\11",
            "",
            "",
            "",
            "\1\26\13\uffff\1\27\42\uffff\1\21\1\22\1\23\1\24\1\25",
            "\1\26\13\uffff\1\35\42\uffff\1\30\1\31\1\32\1\33\1\34\2\uffff\1\36",
            "\1\26\13\uffff\1\35",
            "\1\26\13\uffff\1\35",
            "\1\26\13\uffff\1\35",
            "\1\26\13\uffff\1\35",
            "\1\37",
            "\1\40",
            "\1\41",
            "\1\42",
            "\1\43",
            "\1\44",
            "\1\26\13\uffff\1\35",
            "\1\26\13\uffff\1\35",
            "\1\26\13\uffff\1\35",
            "\1\26\13\uffff\1\35",
            "\1\26\13\uffff\1\35",
            "\1\54\1\45\1\uffff\1\46\66\uffff\1\51\41\uffff\1\56\1\60\1\57\1\55\1\53\1\uffff\1\52\15\uffff\1\47\1\50",
            "\2\64\1\uffff\1\64\66\uffff\1\64\1\63\40\uffff\5\64\1\uffff\1\64\15\uffff\1\61\1\62",
            "\1\26\13\uffff\1\35",
            "\1\26\13\uffff\1\35",
            "\1\26\13\uffff\1\35",
            "\1\26\13\uffff\1\35",
            "\1\26\13\uffff\1\35",
            "\2\64\1\uffff\1\64\66\uffff\1\64\1\63\40\uffff\5\64\1\uffff\1\64\15\uffff\2\64",
            "\1\65",
            "\1\66",
            "\1\67",
            "\1\26\13\uffff\1\35",
            "\1\70",
            "\1\26\13\uffff\1\35",
            "\1\71",
            "\1\26\13\uffff\1\35\42\uffff\1\73\1\74\1\75\1\76\1\77\2\uffff\1\72",
            "\1\26\13\uffff\1\35",
            "\1\26\13\uffff\1\35",
            "\1\26\13\uffff\1\35",
            "\1\26\13\uffff\1\35",
            "\1\100",
            "\1\101",
            "\1\26\13\uffff\1\35\42\uffff\1\102\1\103\1\104\1\105\1\106",
            "\1\107",
            "\1\110",
            "\1\111",
            "\1\112",
            "\1\64\34\uffff\1\113",
            "\1\64\34\uffff\1\113",
            "",
            "",
            "\1\114",
            "\1\115",
            "\1\116",
            "\1\26\13\uffff\1\35",
            "\1\26\13\uffff\1\35",
            "\1\117",
            "\1\26\13\uffff\1\35",
            "\1\26\13\uffff\1\35",
            "\1\26\13\uffff\1\35",
            "\1\26\13\uffff\1\35",
            "\1\26\13\uffff\1\35",
            "\1\120",
            "\1\121",
            "\1\26\13\uffff\1\35",
            "\1\26\13\uffff\1\35",
            "\1\26\13\uffff\1\35",
            "\1\26\13\uffff\1\35",
            "\1\26\13\uffff\1\35",
            "\1\26\13\uffff\1\35",
            "\1\122",
            "\1\26\13\uffff\1\35",
            "\1\123",
            "",
            "\1\124",
            "\1\26\13\uffff\1\35",
            "\1\26\13\uffff\1\35",
            "\1\125",
            "\1\126",
            "\1\127",
            "\1\26\13\uffff\1\35",
            "\1\26\13\uffff\1\35",
            "\1\130",
            "\1\131",
            "\1\26\13\uffff\1\35",
            "\1\26\13\uffff\1\35",
            "\1\132",
            "\1\133",
            "\1\134",
            "\1\135",
            "\1\136",
            "\1\137",
            "\1\26\13\uffff\1\35",
            "\1\140",
            "\1\26\13\uffff\1\35"
    };

    static final short[] dfa_20 = DFA.unpackEncodedString(dfa_20s);
    static final char[] dfa_21 = DFA.unpackEncodedStringToUnsignedChars(dfa_21s);
    static final char[] dfa_22 = DFA.unpackEncodedStringToUnsignedChars(dfa_22s);
    static final short[] dfa_23 = DFA.unpackEncodedString(dfa_23s);
    static final short[] dfa_24 = DFA.unpackEncodedString(dfa_24s);
    static final short[][] dfa_25 = unpackEncodedStringArray(dfa_25s);

    class DFA92 extends DFA {

        public DFA92(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 92;
            this.eot = dfa_20;
            this.eof = dfa_20;
            this.min = dfa_21;
            this.max = dfa_22;
            this.accept = dfa_23;
            this.special = dfa_24;
            this.transition = dfa_25;
        }
        public String getDescription() {
            return "5909:2: (this_changeContract_0= rulechangeContract | this_changeRule_1= rulechangeRule | this_otherchange_2= ruleotherchange | this_changeString_3= rulechangeString | this_changeOther_4= rulechangeOther | this_changeAddress_5= rulechangeAddress )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000060000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x00003F1000180000L,0x0000000000000186L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000211000180000L,0x0000000000000186L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000211000180000L,0x0000000000000184L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000200000180000L,0x0000000000000184L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000180000L,0x0000000000000184L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000180000L,0x0000000000000180L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000180000L,0x0000000000000100L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000FFF000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000C00000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000400010L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000080010L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0xC0000000000001F0L,0x0030000000000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000008000400000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000000480000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x01FFC00000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x3E00000000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000000400000L,0x0000000000000010L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000000000000012L,0x00000000FBA02060L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000060L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000000000010L,0x00000000FBA02000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000000000010L,0x00040E0000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000020L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000000000000010L,0x0000000000020E00L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000000000080010L,0x0000000000020E00L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000000000000010L,0x0000000000020000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000000000800000L,0x0000000000000010L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000400000L,0x0000000000000060L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000000000000012L,0x00040E0000B0C020L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0000000000000012L,0x00040E0000B08020L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000000000000002L,0x0000000000B08020L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000002L,0x0000000000108000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000000000002L,0x0000000000008000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0000000000000002L,0x0000000000B00020L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000002L,0x0000000000100000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0000000000000010L,0x00040E0000B1D020L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0000000000000010L,0x00040E0000B1C020L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000000000000010L,0x00040E8000B0D020L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000000000000010L,0x00040E0000B0D020L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0000000000000010L,0x00040E0000B0C020L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x0000000000000010L,0x00040E8000BDD020L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000000000010L,0x00040E0000BDD020L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000010L,0x00040E0000B9D020L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000000010L,0x00040E0000B9C020L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000002L,0x0000000000090000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000000010L,0x00040E8000B1D020L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000000000002L,0x0000000000A08020L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000000000L,0x00000000FBA02000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0xC0000000000001F0L,0x0030005F00000000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0xC0000000004001F0L,0x0030005F04000000L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000400000L,0x0000000004000000L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0xC0000080000005F0L,0x0030005F04000000L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000008000000400L,0x0000000004000000L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000008000000400L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000000000000000L,0x0000000200000000L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000000000000L,0x0000002000000000L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x01FFC00000000000L,0x0000010000000000L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000000000000000L,0x0000100000000000L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0000000000000000L,0x0003E00000000000L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000000000000000L,0x0030000000000000L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x8000000000000000L});

}