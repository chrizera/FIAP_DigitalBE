package br.com.fiap.view;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import br.com.fiap.bo.JogoBOStub;
import br.com.fiap.bo.JogoBOStub.Buscar;
import br.com.fiap.bo.JogoBOStub.BuscarResponse;
import br.com.fiap.bo.JogoBOStub.Cadastrar;
import br.com.fiap.bo.JogoBOStub.Jogo;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Tela {

	protected Shell shell;
	private Text txtNome;
	private Text txtPreco;
	private Text txtProdutora;
	private Text txtCodigo;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Tela window = new Tela();
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
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(398, 302);
		shell.setText("SWT Application");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(10, 10, 55, 15);
		lblNewLabel.setText("Nome");
		
		txtNome = new Text(shell, SWT.BORDER);
		txtNome.setBounds(10, 31, 155, 21);
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBounds(10, 58, 55, 15);
		lblNewLabel_1.setText("Pre\u00E7o");
		
		txtPreco = new Text(shell, SWT.BORDER);
		txtPreco.setBounds(10, 79, 155, 21);
		
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setBounds(10, 106, 55, 15);
		lblNewLabel_2.setText("Produtora");
		
		txtProdutora = new Text(shell, SWT.BORDER);
		txtProdutora.setBounds(10, 127, 155, 21);
		
		Button btnCadastrar = new Button(shell, SWT.NONE);
		btnCadastrar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//Recuperar as informacoes inseridas
				String nome = txtNome.getText();
				String produtora = txtProdutora.getText();
				float preco = Float.parseFloat(txtPreco.getText());
				
				try {
					//Instanciar o stub
					JogoBOStub stub = new JogoBOStub();
					
					//Instanciar o jogo
					Jogo jogo = new Jogo();
					jogo.setNome("Pkm");
					jogo.setPreco(556);
					jogo.setProdutora("Uhuhu");
					
					//Instanciar o cadastrar
					Cadastrar cadastrar = new Cadastrar();
					
					//Setar o jogo no cadastrar
					cadastrar.setJogo(jogo);
					stub.cadastrar(cadastrar);
					
					
				}
				catch(Exception ee) {
					ee.printStackTrace();
				}
			}
		});
		btnCadastrar.setBounds(10, 162, 154, 25);
		btnCadastrar.setText("Cadastrar");
		
		Label lblCdigo = new Label(shell, SWT.NONE);
		lblCdigo.setBounds(227, 10, 55, 15);
		lblCdigo.setText("C\u00F3digo");
		
		txtCodigo = new Text(shell, SWT.BORDER);
		txtCodigo.setBounds(227, 31, 76, 21);
		
		Button btnBuscar = new Button(shell, SWT.NONE);
		btnBuscar.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					int codigo = Integer.parseInt(txtCodigo.getText());
					JogoBOStub stub = new JogoBOStub();
					Buscar buscar = new Buscar();
					
					buscar.setId(codigo);
					BuscarResponse response = stub.buscar(buscar);
					
					Jogo jogo = response.get_return();
					
					txtNome.setText(jogo.getNome());
					txtPreco.setText(String.valueOf(jogo.getPreco()));
					txtProdutora.setText(jogo.getProdutora());
				}
				catch(Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnBuscar.setBounds(227, 75, 75, 25);
		btnBuscar.setText("Buscar");

	}
}
