import './Eventos.css'

function Eventos() {
  return (
    <main className="eventos">

      <section className="eventos-intro">
        <span className="eventos-label">
          ACONTECE NO BRASA
        </span>

        <div className="eventos-divisor">
  <span>✦</span>
</div>

        <h1>Eventos</h1>

        <p>
          Confira os próximos eventos e momentos especiais
          que preparamos para você.
        </p>
      </section>

      <section className="eventos-container">

        <div className="evento-card">

          <div className="evento-imagem">
            <span>Imagem</span>
          </div>

          <div className="evento-info">

            <span className="evento-data">
              EM BREVE
            </span>

            <h2>Próximos eventos</h2>

            <p>
              Em breve teremos novidades sobre os próximos
              eventos do Brasa de Carvalho.
            </p>

          </div>

        </div>

      </section>

    </main>
  )
}

export default Eventos