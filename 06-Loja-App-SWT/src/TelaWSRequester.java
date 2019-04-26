import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import br.com.fiap.loja.bo.EstoqueBOStub;
import br.com.fiap.loja.bo.EstoqueBOStub.ConsultarProduto;
import br.com.fiap.loja.bo.EstoqueBOStub.ConsultarProdutoResponse;
import br.com.fiap.loja.bo.EstoqueBOStub.ProdutoTO;

public class TelaWSRequester {

	protected Shell shlLojaDoFah;
	private Text text;

	/**
	 * Launch the application.
	 * 
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
		lblDigiteOCdigo.setText("Digite o código do Produto");

		text = new Text(shlLojaDoFah, SWT.BORDER);
		text.setBounds(55, 85, 199, 25);

		Label lblNewLabel = new Label(shlLojaDoFah, SWT.NONE);
		lblNewLabel.setBounds(55, 185, 335, 20);

		Button btnPesquisar = new Button(shlLojaDoFah, SWT.NONE);
		btnPesquisar.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(SelectionEvent e) {
				int codigo = Integer.parseInt(text.getText());

				EstoqueBOStub stub = null;
				try {
					stub = new EstoqueBOStub();
				} catch (AxisFault e2) {
					// TODO Auto-generated catch block
					lblNewLabel.setText("Produto não encontrado");
				}
				ConsultarProduto consulta = new ConsultarProduto();
				consulta.setCodigo(codigo);
				ConsultarProdutoResponse response = null;
				try {
					response = stub.consultarProduto(consulta);
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					lblNewLabel.setText("Sistema fora do ar");
				}
				ProdutoTO produto = response.get_return();
				lblNewLabel.setText(produto.getDescricao());
				
			}
		});
		btnPesquisar.setBounds(105, 116, 90, 30);
		btnPesquisar.setText("Pesquisar");

		MessageBox mb = new MessageBox(shlLojaDoFah, SWT.OK | SWT.CANCEL);

		mb.setMessage("Clique OK caso queira encerrar a aplicação");
		int result = mb.open();
		if (result == SWT.OK) {
			System.out.println("OK foi pressionado");
			System.exit(0); // * encerra programa
		}
		if (result == SWT.CANCEL)
			System.out.println("cancela foi pressionado");

	}
}
