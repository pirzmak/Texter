package viewpackage;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.*;
/**
 * Klasa dodajaca do JTextPane automatyczne
 * zmienianie tekstu na dany emotionek
 * 
 * @see JTextPane
 * 
 * @author Szymon
 */
public class AutoreplaceSmiles extends JTextPane 
{
    
	private static final long serialVersionUID = 1L;
	private ImageIcon SMILE_IMG;
    private  ImageIcon SMILE_IMG1;

  
    /**
     * Konstruktor
     */
    public AutoreplaceSmiles() 
    {
        super();
        initListener();
        this.setEditorKit(new StyledEditorKit());
    }
    /**
     * Initializacaj sprawdzania textu i wstawianie emotienk
     * Sprawdzanie odbywa sie poprzez watek ktory sprawdza 
     * czy w danym tekscie wystepuje fraza znakow odpowiadajaca
     * danemu obrazkowi a nastepnie zamienia ja na obrazek
     * 
     */

    public void initListener() 
    {
    	SMILE_IMG=new ImageIcon("paint.jpg");
        SMILE_IMG1=new ImageIcon("sad.jpg");
        
        getDocument().addDocumentListener(new DocumentListener(){
            public void insertUpdate(DocumentEvent event) {
                final DocumentEvent e=event;
                SwingUtilities.invokeLater(new Runnable() {
                    public void run() {
                        if (e.getDocument() instanceof StyledDocument) {
                            try {
                                StyledDocument doc=(StyledDocument)e.getDocument();
                                int start= Utilities.getRowStart(AutoreplaceSmiles.this,Math.max(0,e.getOffset()-1));
                                int end=Utilities.getWordStart(AutoreplaceSmiles.this,e.getOffset()+e.getLength());
                                String text=doc.getText(start, end-start);

                                int i=text.indexOf(":)");
                                
                                while(i>=0) {
                                    final SimpleAttributeSet attrs=new SimpleAttributeSet(
                                       doc.getCharacterElement(start+i).getAttributes());
                                    if (StyleConstants.getIcon(attrs)==null) {
                                        StyleConstants.setIcon(attrs, SMILE_IMG);
                                        doc.remove(start+i, 2);
                                        doc.insertString(start+i,":)", attrs);
                                    }
                                    i=text.indexOf(":)", i+2);
                                }
                                
                                int j=text.indexOf(":(");
                                
                                while(j>=0) {
                                    final SimpleAttributeSet attrs=new SimpleAttributeSet(
                                       doc.getCharacterElement(start+j).getAttributes());
                                    if (StyleConstants.getIcon(attrs)==null) {
                                        StyleConstants.setIcon(attrs, SMILE_IMG1);
                                        doc.remove(start+j, 2);
                                        doc.insertString(start+j,":(", attrs);
                                    }
                                    j=text.indexOf(":(", j+2);
                                }
                            } catch (BadLocationException e1) {
                                e1.printStackTrace();
                            }
                        }
                    }
                });
            }
            public void removeUpdate(DocumentEvent e) {
            }
            public void changedUpdate(DocumentEvent e) {
            }
        });
    }

}