import './ProdutoCard.css'

function ProdutoCard({ nome, descricao, preco }) {
  return (
    <div className="produto-card">

      <div className="produto-imagem">
        <span>Imagem</span>
      </div>

      <div className="produto-info">
        <h3>{nome}</h3>

        <p>{descricao}</p>

        <span className="produto-preco">
          R$ {preco.toFixed(2).replace('.', ',')}
        </span>
      </div>

    </div>
  )
}

export default ProdutoCard