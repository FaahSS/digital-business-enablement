import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;

public class TelaWSRequester {

	protected Shell shlLojaDoFah;
	private Text text;
	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TelaWSRequester window = new TelaWSRequester();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlLojaDoFah.open();
		shlLojaDoFah.layout();
		while (!shlLojaDoFah.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlLojaDoFah = new Shell();
		shlLojaDoFah.setSize(450, 300);
		shlLojaDoFah.setText("Loja do Fah");
		
		Label lblDigiteOCdigo = new Label(shlLojaDoFah, SWT.NONE);
		lblDigiteOCdigo.setBounds(55, 46, 254, 25);
		lblDigiteOCdigo.setText("Digite o c\u00F3digo do Produto");
		
		text = new Text(shlLojaDoFah, SWT.BORDER);
		text.setBounds(55, 85, 199, 25);
		
		Button btnPesquisar = new Button(shlLojaDoFah, SWT.NONE);
		btnPesquisar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MessageDialog.openInformation(shlLojaDoFah, "SWT", text.getText());
			}
		});
		btnPesquisar.setBounds(105, 116, 90, 30);
		btnPesquisar.setText("Pesquisar");

		MessageBox mb = new MessageBox(shlLojaDoFah, SWT.OK|SWT.CANCEL);
		mb.setMessage("Clique OK caso queira encerrar a aplicação");
		int result = mb.open();
		if ( result == SWT.OK) {
		System.out.println("OK foi pressionado");
		System.exit(0); //* encerra programa
		}
		if (result == SWT.CANCEL)
		System.out.println("cancela foi pressionado");
		
		table = new Table(shlLojaDoFah, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(55, 164, 199, 79);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

	}
}
