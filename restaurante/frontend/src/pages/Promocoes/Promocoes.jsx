import './Promocoes.css'

function Promocoes() {
  return (
    <main className="promocoes">

      <section className="promocoes-intro">
        <span className="promocoes-label">
          OFERTAS DA CASA
        </span>

        <div className="promocoes-divisor">
  <span>✦</span>
</div>

        <h1>Promoções</h1>

        <p>
          Aproveite nossas ofertas especiais e descubra
          novas formas de saborear o Brasa de Carvalho.
        </p>
      </section>

      <section className="promocoes-container">

        <div className="promocao-card">
          <div className="promocao-imagem">
            <span>Imagem</span>
          </div>

          <div className="promocao-info">
            <h2>Promoção especial</h2>

            <p>
              Em breve teremos novidades e ofertas especiais
              para você aproveitar.
            </p>
          </div>
        </div>

      </section>

    </main>
  )
}

export default Promocoes